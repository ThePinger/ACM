//242E
//XORSegment

import java.io.*;
import java.util.*;

public class XORSegment
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        SegmentTree st = new SegmentTree(arr);

        int q = sc.nextInt();
        while(q-->0)
        {
            int typ = sc.nextInt();
            if(typ == 1)
                pw.println(st.query(1, 0, n - 1, sc.nextInt() - 1, sc.nextInt() - 1));
            else
                st.update(1, 0, n - 1, sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
        }

        pw.flush();
        pw.close();
    }

    static class SegmentTree
    {
        int size;
        int[] lazy, arr;
        int[][] bits;
        long[] segTree;

        public SegmentTree(int[] arr)
        {
            this.size = 1;
            while(this.size < arr.length) this.size <<= 1;
            this.size <<= 1;
            this.arr = arr;
            this.lazy = new int[this.size];
            this.segTree = new long[this.size];
            this.bits = new int[20][this.size];
            this.build(1, 0, this.arr.length - 1);
        }

        public void build(int node, int l, int r)
        {
            if(l == r)
            {
                for(int i = 0; i < 20; i++)
                    if((this.arr[l] & 1 << i) == 1 << i)
                        this.bits[i][node]++;
                this.segTree[node] = this.arr[l];
                return;
            }

            int mid = (l + r) / 2;
            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);

            for(int i = 0; i < 20; i++)
                this.bits[i][node] = this.bits[i][node << 1] + this.bits[i][node << 1 | 1];
            this.segTree[node] = this.segTree[node << 1] + this.segTree[node << 1 | 1];
        }

        public void propagate(int node, int l, int r)
        {
            long sumA = 0;
            long sumB = 0;
            int mid = (l + r) / 2;
            for(int i = 0; i < 20; i++)
            {
                if((this.lazy[node] & 1 << i) == 1 << i)
                {
                    this.bits[i][node << 1] = (mid - l + 1) - this.bits[i][node << 1];
                    this.bits[i][node << 1 | 1] = (r - mid) - this.bits[i][node << 1 | 1];
                }
                sumA += this.bits[i][node << 1] * (1l << i);
                sumB += this.bits[i][node << 1 | 1] * (1l << i);
            }

            this.lazy[node << 1] ^= this.lazy[node];
            this.lazy[node << 1 | 1] ^= this.lazy[node];
            this.lazy[node] = 0;
            this.segTree[node << 1] = sumA;
            this.segTree[node << 1 | 1] = sumB;
        }

        public void update(int node, int l, int r, int start, int end, int val)
        {
            if(l > end || r < start) return;
            if(l >= start && r <= end)
            {
                long sum = 0;
                for(int i = 0; i < 20; i++)
                {
                    if((val & 1 << i) == 1 << i)
                        this.bits[i][node] = (r - l + 1) - this.bits[i][node];
                    sum += this.bits[i][node] * (1l << i);
                }

                this.lazy[node] ^= val;
                this.segTree[node] = sum;
                return;
            }

            int mid = (l + r) / 2;
            propagate(node, l, r);
            update(node << 1, l, mid, start, end, val);
            update(node << 1 | 1, mid + 1, r, start, end, val);

            for(int i = 0; i < 20; i++)
                this.bits[i][node] = this.bits[i][node << 1] + this.bits[i][node << 1 | 1];
            this.segTree[node] = this.segTree[node << 1] + this.segTree[node << 1 | 1];
        }

        public long query(int node, int l, int r, int start, int end)
        {
            if(l > end || r < start) return 0;
            if(l >= start && r <= end)
                return this.segTree[node];

            int mid = (l + r) / 2;
            propagate(node, l, r);
            long q1 = query(node << 1, l, mid, start, end);
            long q2 = query(node << 1 | 1, mid + 1, r, start, end);
            return q1 + q2;
        }
    }
}