//10911
//Forming Quiz Teams

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static double[] memo;
    static double[][] dist;

    public static boolean visited(int idx, int mask)
    {
        return ((1 << idx) & mask) == 1 << idx;
    }

    public static double dp(int mask)
    {
        if(Integer.bitCount(mask) == n)
            return 0;

        if(memo[mask] != -1)
            return memo[mask];

        double ans = Double.MAX_VALUE;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(i != j && !visited(i, mask) && !visited(j, mask))
                    ans = Math.min(ans, dist[i][j] + dp(mask | (1 << i) | (1 << j)));

        return memo[mask] = ans;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;

        while(true)
        {
            n = 2 * sc.nextInt();

            if(n == 0) break;

            Point[] arr = new Point[n];
            for(int i = 0; i < n; i++)
            {
                sc.next();
                arr[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            dist = new double[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    dist[i][j] = arr[i].dist(arr[j]);

            memo = new double[1 << n];
            Arrays.fill(memo, -1);
            pw.printf("Case %d: %.2f\n", t++, dp(0));
        }

        pw.flush();
        pw.close();
    }

    static class Point
    {
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public double square(double x)
        {
            return x * x;
        }
    
        public double dist(Point p)
        {
            return Math.sqrt(square(this.x - p.x) + square(this.y - p.y));
        }
    }
}