//11456
//Trainsorting

import java.io.*;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int[] lis = new int[n];
            int[] lds = new int[n];
            for(int i = n - 1; i > -1; i--)
            {
                int max = 1;
                for(int j = n - 1; j > i; j--)
                    if(arr[i] < arr[j])
                        max = Math.max(max, lis[j] + 1);
                lis[i] = max;

                max = 1;
                for(int j = n - 1; j > i; j--)
                    if(arr[i] > arr[j])
                        max = Math.max(max, lds[j] + 1);
                lds[i] = max;
            }

            int ans = 1;
            for(int i = 0; i < n; i++)
                ans = Math.max(ans, lis[i] + lds[i] - 1);

            pw.println(n == 0 ? 0 : ans);
        }

        pw.flush();
        pw.close();
    }
}