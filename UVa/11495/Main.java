//11495
//Bubbles and Buckets

import java.io.*;
import java.util.*;

public class Main 
{

    public static int mergeSort(int[] arr, int start, int end)
    {
        if(start == end) return 0;

        int mid = (start + end) / 2;
        int ms1 = mergeSort(arr, start, mid);
        int ms2 = mergeSort(arr, mid + 1, end);
        return ms1 + ms2 + merge(arr, start, mid, end);
    }

    public static int merge(int[] arr, int start, int mid, int end)
    {
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;

        int[] tmpArr = new int[end - start + 1];
        int swaps = 0;
        int i = 0;
        while(start1 <= end1 || start2 <= end2)
        {
            if(start1 > end1)
                tmpArr[i++] = arr[start2++];
            else if(start2 > end2)
                tmpArr[i++] = arr[start1++];
            else if(arr[start1] <= arr[start2])
                tmpArr[i++] = arr[start1++];
            else
            {
                tmpArr[i++] = arr[start2++];
                swaps += mid - start1 + 1;
            }
        }

        for(i = 0; i < tmpArr.length; i++)
            arr[start++] = tmpArr[i];

        return swaps;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            if(n == 0) break;

            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            pw.println(mergeSort(arr, 0, n - 1) % 2 == 0 ? "Carlos" : "Marcelo");
        }

        pw.flush();
        pw.close();
    }    
}