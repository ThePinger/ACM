//272C
//DimaStaircase

import java.io.*;
import java.util.*;

public class DimaStaircase
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            
        long max = 0;
        int m = sc.nextInt();
        while(m-->0)
        {
            int w = sc.nextInt() - 1;
            int h = sc.nextInt();
            if(max == 0)
            {
                pw.println(arr[w]);
                max = h + arr[w];
            }
            else
            {
                pw.println(Math.max(max, arr[w]));
                max = h + Math.max(max, arr[w]);
            }
        }

        pw.flush();
        pw.close();
    }
}