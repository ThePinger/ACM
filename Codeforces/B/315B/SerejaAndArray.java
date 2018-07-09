//315B
//SerejaAndArray

import java.io.*;
import java.util.*;

public class SerejaAndArray
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int cumm = 0;
        while(m-->0)
        {
            int t = sc.nextInt();
            if(t == 1)
                arr[sc.nextInt() - 1] = sc.nextInt() - cumm;
            else if(t == 2)
                cumm += sc.nextInt();
            else
                pw.println(arr[sc.nextInt() - 1] + cumm);
        }

        pw.flush();
        pw.close();
    }
}