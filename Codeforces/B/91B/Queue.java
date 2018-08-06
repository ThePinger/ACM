//91B
//Queue

import java.util.*;

public class Queue
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] copy = arr.clone();
        Arrays.sort(copy);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++)
            map.put(copy[i], i);

        Arrays.fill(copy, 0);
        for(int i = 0; i < n; i++)
            copy[map.get(arr[i])] = i;

        SegmentTree st = new SegmentTree(copy);
        for(int i = 0; i < n; i++)
        {
            int idx = map.get(arr[i]);
            int query = st.query(1, 0, n - 1, 0, idx - 1);
            if(query > i) sb.append(query - i - 1 + " ");
            else sb.append("-1 ");
        }

        System.out.println(sb);
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
            this.segTree[node] = Math.max(this.segTree[node << 1], this.segTree[node << 1 | 1]);
        }

        public int query(int node, int start, int end, int l, int r)
        {
            if(start > r || end < l) return Integer.MIN_VALUE;
            if(start >= l && end <= r) return this.segTree[node];

            int mid = (start + end) / 2;
            int left = query(node << 1, start, mid, l, r);
            int right = query(node << 1 | 1, mid + 1, end, l, r);

            return Math.max(left, right);
        }
    }
}