// Larry's Array

import java.io.*;
import java.util.*;

public class LarryArray 
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++)
            {
                int j = 0;
                while(j < n - 2)
                {
                    if(arr[j] <= arr[j + 1] && arr[j] <= arr[j + 2]) j++;
                    else
                    {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = arr[j + 2];
                        arr[j + 2] = tmp;
                    }
                }
            }

            boolean flag = true;
            for(int i = 0; i < n - 1; i++)
                flag &= arr[i] <= arr[i + 1];

            pw.println(flag ? "YES" : "NO");
        }

        pw.flush();
        pw.close();
    }    
}