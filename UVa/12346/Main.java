//12346
//Water Gate Manag.

import java.util.*;
import java.io.*;

public class Main
{
    static int[] rate, cost;
    static int n, vol, hrs;

    public static int getCost(int i, double volR)
    {
        if(i == n || volR <= 0)
        {
            if(volR <= 0) return 0;
            else return  (int) 1e9;
        }

        int take = cost[i] + getCost(i + 1, volR - rate[i]);
        int leave = getCost(i + 1, volR);

        return Math.min(take, leave);
    }

    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rate = new int[n];
        cost = new int[n];
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rate[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 1; i <= m; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vol = Integer.parseInt(st.nextToken());
            hrs = Integer.parseInt(st.nextToken());
            int minC = getCost(0, vol / hrs);
            if(minC < (int) 1e9) System.out.println("Case " + i + ": " + minC);
            else System.out.println("Case " + i + ": IMPOSSIBLE");
        } 


    }
}