//1250
//RobotChallenge

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static Point[] arr;
    static double[][] memo;

    public static double dp(int idx, int last)
    {
        if(idx == n)
            return 1 + arr[last].dist(new Point(100, 100, 0));

        if(memo[idx][last] != -1)
            return memo[idx][last];

        double take = Double.MAX_VALUE, leave = Double.MAX_VALUE;
        if(idx == 0)
            take = dp(idx + 1, idx);
        else
        {
            take = 1 + arr[last].dist(arr[idx]) + dp(idx + 1, idx);
            leave = arr[idx].penalty + dp(idx + 1, last);
        }

        return memo[idx][last] = Math.min(take, leave);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            n = sc.nextInt() + 1;

            if(n == 1) break;

            arr = new Point[n];
            arr[0] = new Point(0, 0, 0);
            for(int i = 1; i < n; i++)
                arr[i] = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());

            memo = new double[n][n];
            for(double[] x : memo)
                Arrays.fill(x, -1);

            pw.printf("%.3f\n", dp(0, 0));
        }

        pw.flush();
        pw.close();
    }

    static class Point
    {
        int x, y, penalty;

        public Point(int x, int y, int penalty)
        {
            this.x = x;
            this.y = y;
            this.penalty = penalty;
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