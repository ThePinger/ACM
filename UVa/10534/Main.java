//10534
//Wavio Sequence

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int[] lis = new int[n];
            int[] lds = new int[n];
            ArrayList<Integer> bestLIS = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                int length = Collections.binarySearch(bestLIS, arr[i]);
                if(length < 0) length = - (length + 1);

                if(length == bestLIS.size())
                    bestLIS.add(arr[i]);
                else
                    bestLIS.set(length, Math.min(arr[i], bestLIS.get(length)));
                    
                lis[i] = length + 1;
            }

            bestLIS = new ArrayList<>();
            for(int i = n - 1; i > -1; i--)
            {
                int length = Collections.binarySearch(bestLIS, arr[i]);
                if(length < 0) length = - (length + 1);

                if(length == bestLIS.size())
                    bestLIS.add(arr[i]);
                else
                    bestLIS.set(length, Math.min(arr[i], bestLIS.get(length)));

                lds[i] = length + 1;
            }

            int ans = 1;
            for(int i = 0; i < n; i++)
            {
                int min = Math.min(lis[i], lds[i]);
                ans = Math.max(ans, min + min - 1);
            }

            pw.println(ans);
        }
        
        pw.flush();
        pw.close();
    }
}