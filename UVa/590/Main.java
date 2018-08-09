//590
//Always on the Run

import java.io.*;
import java.util.*;

public class Main
{

    static int n, flights;
    static int[][] memo;
    static int[][] pricesAvailable;
    static int[][][] cost;
    static final int INF = (int) 1e8;

    public static int dp(int city, int day)
    {
        if(day == flights)
        {
            if(city == n - 1)
                return 0;
            return INF;
        }

        if(memo[city][day] != -1) return memo[city][day];

        int min = INF;
        for(int i = 0; i < n; i++)
            if(i != city && cost[day % pricesAvailable[city][i]][city][i] != 0)
                min = Math.min(min, cost[day % pricesAvailable[city][i]][city][i] + dp(i, day + 1));

        return memo[city][day] = min;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = 1;
        while(true)
        {
            n = sc.nextInt();
            flights = sc.nextInt();

            if(n == 0 && flights == 0) break;

            cost = new int[30][n][n];
            pricesAvailable = new int[n][n];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(i != j)
                    {
                        int c = sc.nextInt();
                        pricesAvailable[i][j] = c;
                        for(int k = 0; k < c; k++)
                            cost[k][i][j] = sc.nextInt();
                    }
                }
            }

            memo = new int[n][flights];
            for(int[] xx : memo)
                Arrays.fill(xx, -1);

            int ans = dp(0, 0);
            pw.println("Scenario #" + t++);
            if(ans < INF) pw.println("The best flight costs " + ans + ".");
            else pw.println("No flight possible.");
            pw.println();
        }

        pw.flush();
        pw.close();
    }
}