//597C
//Subsequences

import java.util.*;

public class Subsequences
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        FenwickTree[] trees = new FenwickTree[k + 2];
        for(int i = 0; i < k + 2; i++)
            trees[i] = new FenwickTree(n);

        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            trees[1].update(1, tmp);
            for(int j = 2; j < trees.length; j++)
                trees[j].update(trees[j - 1].query(tmp - 1), tmp);
        }

        System.out.println(trees[k + 1].query(n));
    }



    static class FenwickTree
    {
        long[] arr, fenTree;

        public FenwickTree(int n)
        {
            this.fenTree = new long[n + 1];
        }

        public FenwickTree(long[] arr)
        {
            this.arr = arr;
            this.fenTree = new long[arr.length + 1];
            this.build();
        }

        public void build()
        {
            for(int i = 0; i < this.arr.length; i++)
                this.update(this.arr[i], i + 1);
        }

        public void update(long val, int idx)
        {
            while(idx < this.fenTree.length)
            {
                this.fenTree[idx] += val;
                idx += idx & -idx;
            }
        }

        public long query(int start, int end)
        {
            return query(start) - query(end);
        }

        public long query(int idx)
        {
            long sum = 0;
            while(idx > 0)
            {
                sum += this.fenTree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}