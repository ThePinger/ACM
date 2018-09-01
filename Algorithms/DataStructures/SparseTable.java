

public class SparseTable
{
    static int[] arr;
    static int[][] sparseTable;

    public static void buildTable(int n)
    {
        int log = (int) Math.floor((Math.log(n) / Math.log(2))) + 1;
        sparseTable = new int[n][log];

        for(int i = 0; i < n; i++)
            sparseTable[i][0] = arr[i];

        for(int j = 1; j < log; j++)
            for(int i = 0; i + (1 << (j - 1)) < n; i++)
                sparseTable[i][j] = Math.max(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
    }

    public static int query(int l, int r)
    {
        if(l > r) return 0;
        int log = (int) Math.floor(Math.log(r - l + 1) / Math.log(2));
        return Math.max(sparseTable[l][log], sparseTable[r - (1 << log) + 1][log]);
    }
}