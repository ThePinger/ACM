
import java.util.*;

public class SegmentTree
{
    int[] segTree, lazy, arr;

    public SegmentTree(int[] arr)
    {
        int n = 1;
        while(n < arr.length) n <<= 1;
        n <<= 1;
        this.arr = arr;
        this.lazy = new int[n];
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
        this.segTree[node] = this.segTree[node << 1] + this.segTree[node << 1 | 1];
    }

    public void propagate(int node, int start, int end)
    {
        int mid = (start + end) / 2;
        this.lazy[node << 1] += this.lazy[node];
        this.lazy[node << 1 | 1] += this.lazy[node];
        this.segTree[node << 1] = (mid - start + 1) * this.lazy[node];
        this.segTree[node << 1 | 1] = (end - mid) * this.lazy[node];
        this.lazy[node] = 0;
    }

    public void update(int node, int start, int end, int l, int r, int val)
    {
        if(start > r || end < l) return;
        if(start >= l && end <= r)
        {
            this.lazy[node] += val;
            this.segTree[node] += val;
        }

        this.propagate(node, start, end);
        int mid = (start + end) / 2;
        update(node << 1, start, mid, l, r, val);
        update(node << 1 | 1, mid + 1, end, l, r, val);
        this.segTree[node] = this.segTree[node << 1] + this.segTree[node << 1 | 1];
    }

    public int query(int node, int start, int end, int l, int r)
    {
        if(start > r || end < l) return 0;
        if(start >= l && end <= r) return this.segTree[node];

        this.propagate(node, start, end);
        int mid = (start + end) / 2;
        int q1 = query(node << 1, start, mid, l, r);
        int q2 = query(node << 1 | 1, mid + 1, end, l, r);
        return q1 + q2;
    }

}
