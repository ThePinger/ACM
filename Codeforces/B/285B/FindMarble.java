//285B
//FindMarble

import java.util.*;

public class FindMarble
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int st = sc.nextInt() - 1;
        int en = sc.nextInt() - 1;

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt() - 1;  
            
        int count = 0;
        boolean[] vis = new boolean[n];
        while(!vis[st] && st != en)
        {
            vis[st] = true;
            st = arr[st];
            count++;
        }

        if(st == en) System.out.println(count);
        else System.out.println(-1);
    }
}