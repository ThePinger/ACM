//295A
//GregArray

import java.io.*;
import java.util.*;

public class GregArray
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in); 
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        long[] vals = new long[n + 1];
        for(int i = 1; i < n + 1; i++)
            vals[i] = sc.nextInt();

        Triple[] operations = new Triple[m + 1];
        for(int i = 1; i < m + 1; i++)
            operations[i] = new Triple(sc.nextInt(), sc.nextInt(), sc.nextInt());

        int[] queries = new int[m + 1];
        for(int i = 0; i < k; i++)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();
            queries[l]++;
            if(r < m) queries[r + 1]--;
        }

        for(int i = 1; i < m + 1; i++)
            queries[i] += queries[i - 1];

        long[] arr = new long[n + 1];        
        for(int i = 1; i < m + 1; i++)
        {
            long add = 1l * queries[i] * operations[i].val;
            arr[operations[i].l] += add;
            if(operations[i].r < n) arr[operations[i].r + 1] -= add;   
        }

        for(int i = 1; i < n + 1; i++)
            arr[i] += arr[i - 1];

        for(int i = 1; i < n + 1; i++)
            arr[i] += vals[i];

        for(int i = 1; i < n + 1; i++) pw.print(arr[i] + " ");

        pw.println();
        pw.flush();
        pw.close();
    }

    static class Triple
    {
        int l, r, val;

        public Triple(int l, int r, int val)
        {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
}