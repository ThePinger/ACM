//558
//Wormholes

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static ArrayList<Edge>[] adjList;

    public static boolean bellmanFord(int s)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        for(int i = 0; i < n - 1; i++)
            for(int j = 0; j < n; j++)
                if(dist[j] < Integer.MAX_VALUE)
                    for(Edge nxt : adjList[j])
                        dist[nxt.node] = Math.min(dist[nxt.node], dist[j] + nxt.cost);

        boolean flag = false;
        for(int i = 0; i < n; i++)
            for(Edge nxt : adjList[i])
                if(dist[i] + nxt.cost < dist[nxt.node])
                    flag = true;

        return flag;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        while(t-->0)
        {
            n = sc.nextInt();
            int m = sc.nextInt();

            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            while(m-->0)
                adjList[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));

            pw.println(bellmanFord(0) ? "possible" : "not possible");
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