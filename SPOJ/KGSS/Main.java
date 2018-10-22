//KGSS

import java.io.*;
import java.util.*;

public class Main
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
            String typ = sc.next();
            if(typ.equals("U"))
            {
                int idx = sc.nextInt() - 1;
                int val = sc.nextInt();
                st.update(1, 0, arr.length - 1, idx, idx, val);
            }
            else
            {
                int l = sc.nextInt();
                int r = sc.nextInt();
                Pair ans = st.query(1, 0, arr.length - 1, l - 1, r - 1);
                pw.println(ans.x + ans.y);
            }
        }

        pw.flush();
        pw.close();
    }

    static class Pair
    {
        long x, y;

        public Pair(long x, long y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static class SegmentTree
    {
        int[] arr;
        Pair[] segTree;

        public SegmentTree(int[] arr)
        {
            int n = 1;
            while(n < arr.length) n <<= 1;
            n <<= 1;
            this.arr = arr;
            segTree = new Pair[n];
            for(int i = 0; i < n; i++)
                segTree[i] = new Pair(0, 0);
            build(1, 0, arr.length - 1);
        }

        public Pair max(Pair a, Pair b)
        {
            long[] tmp = new long[]{a.x, a.y, b.x, b.y};
            Arrays.sort(tmp);
            return new Pair(tmp[2], tmp[3]);
        }

        public void build(int node, int l, int r)
        {
            if(l == r)
            {
                segTree[node] = new Pair(arr[l], 0);
                return;
            }

            int mid = (l + r) / 2;
            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);
            segTree[node] = max(segTree[node << 1], segTree[node << 1 | 1]);
        }

        public void update(int node, int l, int r, int start, int end, int val)
        {
            if(l > end || r < start) return;
            if(l >= start && r <= end)
            {
                segTree[node].x = val;
                return;
            }

            int mid = (l + r) / 2;
            update(node << 1, l, mid, start, end, val);
            update(node << 1 | 1, mid + 1, r, start, end, val);
            segTree[node] = max(segTree[node << 1], segTree[node << 1 | 1]);
        }

        public Pair query(int node, int l, int r, int start, int end)
        {
            if(l > end || r < start) return new Pair(0, 0);
            if(l >= start && r <= end)
                return segTree[node];

            int mid = (l + r) / 2;
            Pair q1 = query(node << 1, l, mid, start, end);
            Pair q2 = query(node << 1 | 1, mid + 1, r, start, end);
            return max(q1, q2);
        }
    }
}