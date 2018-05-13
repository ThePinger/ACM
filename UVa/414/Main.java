//414

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) 
        {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int maxX = 0;
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
            {
                String line = br.readLine();
                for(int j = 0; j < line.length(); j++)
                    if(line.charAt(j) == 'X')
                        arr[i]++;
                maxX = Math.max(arr[i], maxX);
            }

            int gaps = 0;
            for(int i = 0; i < n; i++)
                gaps += (maxX - arr[i]);

            System.out.println(gaps);
        }
        
    }
}