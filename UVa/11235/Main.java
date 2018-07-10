//11235
//Frequent Values

import java.io.*;
import java.util.*;

public class Main
{

    static int[] freq;
    static int[][] sparseTable;

    public static void buildTable(int n)
    {
        int log = (int) Math.floor((Math.log(n) / Math.log(2))) + 1;
        sparseTable = new int[n][log];

        for(int i = 0; i < n; i++)
            sparseTable[i][0] = freq[i];

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

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            int q = sc.nextInt();
            freq = new int[n];
            int[] map = new int[n];
            int[] left = new int[n];
            int[] right = new int[n];

            int j = 0;
            int count = 1;
            int pre = sc.nextInt();
            for(int i = 1; i < n; i++)
            {
                int cur = sc.nextInt();
                if(cur == pre) 
                {
                    count++;
                    map[i] = j;
                }
                else
                {
                    right[j] = i - 1;
                    freq[j] = count;
                    j++;
                    left[j] = i;
                    map[i] = j; 
                    pre = cur;
                    count = 1;
                }
            }

            buildTable(j + 1);

            while(q-->0)
            {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;
                int idxL = map[l];
                int idxR = map[r];
                if(idxL == idxR) pw.println(r - l + 1);
                else
                {
                    int max = Math.max(right[idxL] - l + 1, r - left[idxR] + 1);
                    max = Math.max(max, query(idxL + 1, idxR - 1));
                    pw.println(max);
                }
            }
        }

        pw.flush();
        pw.close();
    }
}
