//12532
//Interval Product

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int q = sc.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
            {
                int tmp = sc.nextInt();
                arr[i] = tmp == 0 ? 0 : tmp > 0 ? 1 : -1;
            }

            SegmentTree tree = new SegmentTree(arr);
            while(q-->0)
            {
                String typ = sc.next();
                if(typ.equals("C"))
                {
                    int point = sc.nextInt() - 1;
                    int val = sc.nextInt();
                    tree.update(1, 0, n - 1, point, point, val == 0 ? 0 : val > 0 ? 1 : -1);
                }
                else
                {
                    int ans = tree.query(1, 0, n - 1, sc.nextInt() - 1, sc.nextInt() - 1);
                    if(ans == 0) pw.print(0);
                    else pw.print(ans > 0 ? '+' : '-');
                }
            }
            pw.println();
        }

        pw.flush();
        pw.close();
    }

    static class SegmentTree
    {
        int[] arr, segTree;

        public SegmentTree(int[] arr)
        {
            int n = 1;
            while(n < arr.length) n <<= 1;
            n <<= 1;
            this.arr = arr;
            this.segTree = new int[n];
            Arrays.fill(this.segTree, 1);
            this.build(1, 0, arr.length - 1);
        }

        public void build(int node, int start, int end)
        {
            if(start == end)
            {
                this.segTree[node] = this.arr[start];
                return;
            }

            int mid = (start + end) / 2;
            build(node << 1, start, mid);
            build(node << 1 | 1, mid + 1, end);
            this.segTree[node] = this.segTree[node << 1] * this.segTree[node << 1 | 1];
        }

        public void update(int node, int start, int end, int l, int r, int val)
        {
            if(start > r || end < l) return;
            if(start >= l && end <= r)
            {
                this.segTree[node] = val;
                return;
            }

            int mid = (start + end) / 2;
            update(node << 1, start, mid, l, r, val);
            update(node << 1 | 1, mid + 1, end, l, r, val);
            this.segTree[node] = this.segTree[node << 1] * this.segTree[node << 1 | 1];
        }

        public int query(int node, int start, int end, int l, int r)
        {
            if(start > r || end < l) return 1;
            if(start >= l && end <= r) return this.segTree[node];

            int mid = (start + end) / 2;
            int q1 = query(node << 1, start, mid, l, r);
            int q2 = query(node << 1 | 1, mid + 1, end, l, r);
            return q1 * q2;
        }

    }
}
