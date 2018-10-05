//482B
//InterestingArray

import java.io.*;
import java.util.*;

public class InterestingArray
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        SegmentTree tree = new SegmentTree(n);
        Query[] queries = new Query[m];
        
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int val = Integer.parseInt(st.nextToken());

            tree.update(1, 0, n - 1, l, r, val);
            queries[i] = new Query(l, r, val);
        }

        boolean flag = true;
        for(int i = 0; i < m; i++)
            flag &= tree.query(1, 0, n - 1, queries[i].l, queries[i].r) == queries[i].val;

        if(flag)
        {
            pw.println("YES");
            for(int i = 0; i < n; i++)
                pw.print(tree.query(1, 0, n - 1, i, i) + " ");
            pw.println();
        }
        else pw.println("NO");

        pw.flush();
        pw.close();
    }

    static class Query
    {
        int l, r, val;

        public Query(int l, int r, int val)
        {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }

    static class SegmentTree
    {
        int[] segTree, lazy;

        public SegmentTree(int size)
        {
            int n = 1;
            while(n < size) n <<= 1;
            n <<= 1;
            this.lazy = new int[n];
            this.segTree = new int[n];
        }

        public void propagate(int node)
        {
            this.lazy[node << 1] |= this.lazy[node];
            this.lazy[node << 1 | 1] |= this.lazy[node];
            this.segTree[node << 1] |= this.lazy[node];
            this.segTree[node << 1 | 1] |= this.lazy[node];
            this.lazy[node] = 0;
        }

        public void update(int node, int start, int end, int l, int r, int val)
        {
            if(start > r || end < l) return;
            if(start >= l && end <= r)
            {
                this.lazy[node] |= val;
                this.segTree[node] |= val;
                return;
            }

            propagate(node);
            int mid = (start + end) / 2;
            update(node << 1, start, mid, l, r, val);
            update(node << 1 | 1, mid + 1, end, l, r, val);

            this.segTree[node] = this.segTree[node << 1] & this.segTree[node << 1 | 1];
        }

        public int query(int node, int start, int end, int l, int r)
        {
            if(start > r || end < l) return Integer.MAX_VALUE;
            if(start >= l && end <= r)
                return this.segTree[node];

            propagate(node);
            int mid = (start + end) / 2;
            int q1 = query(node << 1, start, mid, l, r);
            int q2 = query(node << 1 | 1, mid + 1, end, l, r);

            return q1 & q2;
        }
    }
}