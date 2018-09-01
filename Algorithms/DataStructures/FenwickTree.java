

public class FenwickTree
{
    int[] arr, fenTree;

    public FenwickTree(int[] arr)
    {
        this.arr = arr;
        this.fenTree = new int[arr.length + 1];
        this.build();
    }

    public void build()
    {
        for(int i = 0; i < n; i++)
            this.update(this.arr[i], i + 1);
    }

    public void update(int val, int idx)
    {
        while(idx < this.fenTree.length)
        {
            this.fenTree[idx] += val;
            idx += idx & -idx;
        }
    }

    public int query(int start, int end)
    {
        return query(start) - query(end);
    }

    public int query(int idx)
    {
        int sum = 0;
        while(idx > 0)
        {
            sum += this.fenTree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
}