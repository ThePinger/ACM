//10611
//The Playboy Chimp
//BinarySearch

import java.io.*;
import java.util.StringTokenizer;

public class Main 
{
    static int[] heights;
    static int max, min;

    public static void binarySearch(int h)
    {
        int hi = heights.length - 1;
        int lo = 0;
        max = -1;
        while(lo <= hi)
        {
            int mid = (hi + lo) / 2;
            if(heights[mid] > h && (heights[mid] < max || max == -1))
            {
                max = heights[mid];
                hi  = mid;
            }
            else
                lo = mid;
            
            if(hi - lo == 1)
            {
                if(heights[hi] > h && (heights[hi] < max || max == -1))
                    max = heights[hi];
                if(heights[lo] > h && (heights[lo] < max || max == -1))
                    max = heights[lo];
                break;
            }
        }

        hi = heights.length - 1;
        lo = 0;
        min = -1;
        while(lo <= hi)
        {
            int mid = (hi + lo) / 2;
            if(heights[mid] < h && (heights[mid] > min || min == -1))
            {
                min = heights[mid];
                lo  = mid;
            }
            else
                hi = mid;
            
            if(hi - lo == 1)
            {
                if(heights[hi] < h && (heights[hi] > min || min == -1))
                    min = heights[hi];
                if(heights[lo] < h && (heights[lo] > min || min == -1))
                    min = heights[lo];
                break;
            }
        }
    }

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        heights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            heights[i] = Integer.parseInt(st.nextToken());
        
        int q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
        {
            int h = Integer.parseInt(st.nextToken());
            binarySearch(h);
            String mi = "X";
            String mx = "X";
            if(min != -1) mi = min + "";
            if(max != -1) mx = max + "";
            sb.append(mi + " " + mx + "\n");
        }

        System.out.print(sb);
    }
}