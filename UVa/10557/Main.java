//10557
//XYZZY

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static ArrayList<Edge>[] adjList;

    public static boolean bellmanFord(int s)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[s] = 100;

        for(int i = 0; i < n - 1; i++)
            for(int j = 0; j < n; j++)
                if(dist[j] > 0)
                    for(Edge nxt : adjList[j])
                        dist[nxt.node] = Math.max(dist[nxt.node], dist[j] + nxt.cost);

        boolean[][] reachable = new boolean[n][n];
        for(int i = 0; i < n; i++)
            for(Edge nxt : adjList[i])
                    reachable[i][nxt.node] = true; 

        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    reachable[i][j] |= reachable[i][k] && reachable[k][j];

        boolean flag = false;
        for(int i = 0; i < n; i++)
            for(Edge nxt : adjList[i])
                if(dist[i] > 0 && dist[i] + nxt.cost > dist[nxt.node] && reachable[nxt.node][n - 1])
                    flag = true;

        return flag || dist[n - 1] > 0;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            n = sc.nextInt();

            if(n == -1) break;

            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < n; i++)
            {
                int cost = sc.nextInt();
                int m = sc.nextInt();

                while(m-->0)
                    adjList[i].add(new Edge(sc.nextInt() - 1, cost));
            }

            pw.println(bellmanFord(0) ? "winnable" : "hopeless");
        }

        pw.flush();
        pw.close();
    }

    static class Edge implements Comparable<Edge>
    {
        int node, cost;

        public Edge(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Edge e)
        {
            if(this.cost == e.cost)
                return this.node - e.node;
            return this.cost - e.cost;
        }
    }    
}
