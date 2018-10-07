//721C
//Journey

import java.io.*;
import java.util.*;

public class Journey
{

    static int n, t;
    static int[][] memo;
    static ArrayList<Edge>[] adjList;
    static PrintWriter pw = new PrintWriter(System.out);


    public static int dp(int cur, int rem)
    {
        if(rem < 0) return t + 1;
        if(cur == n - 1)
        {
            if(rem == 0)
                return 0;
            return t + 1;
        } 

        if(memo[cur][rem] != -1)
            return memo[cur][rem];

        int min = t + 1;
        for(Edge e : adjList[cur])
            min = Math.min(min, e.cost + dp(e.nxt, rem - 1));
        
        return memo[cur][rem] = min;
    }

    public static void trace(int cur, int rem)
    {
        if(cur == n - 1) pw.println(cur + 1);
        else
        {
            pw.print(cur + 1 + " ");
            int tmp = memo[cur][rem];
            for(Edge e : adjList[cur])
            {
                if(tmp == e.cost + dp(e.nxt, rem - 1))
                {
                    trace(e.nxt, rem - 1);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        t = sc.nextInt();

        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        memo = new int[n][m + 1];
        for(int[] x : memo)
            Arrays.fill(x, -1);

        for(int i = 0; i < m; i++)
        {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            adjList[a].add(new Edge(b, c));
        }

        int ver = 0;
        for(int i = 0; i <= m; i++)
            if(dp(0, i) <= t)
                ver = i;

        pw.println(ver + 1);
        trace(0, ver);
        pw.flush();
        pw.close();
    }

    static class Edge
    {
        int nxt, cost;

        public Edge(int nxt, int cost)
        {
            this.nxt = nxt;
            this.cost = cost;
        }
    }
}