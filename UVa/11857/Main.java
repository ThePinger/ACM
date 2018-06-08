//11857
//Driving Range

import java.io.*;
import java.util.*;

public class Main
{

    static int sets;
    static boolean[] taken;
    static ArrayList<Edge>[] adjList;
    static PriorityQueue<Edge> nxtEdges;

    public static int primMST()
    {
        int min = Integer.MIN_VALUE;
        process(0);
        while(!nxtEdges.isEmpty())
        {
            Edge edge = nxtEdges.poll();
            if(!taken[edge.nxt])
            {
                sets--;
                process(edge.nxt);
                min = Math.max(min, edge.cost);
            }
        }
        return min;
    }

    public static void process(int cur)
    {
        taken[cur] = true;
        for(Edge e : adjList[cur])
            nxtEdges.add(e);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);   
        
        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n == 0 && m == 0) break;

            sets = n;
            taken = new boolean[n];
            adjList = new ArrayList[n];
            nxtEdges = new PriorityQueue<>();
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < m; i++)
            {
                int st = sc.nextInt();
                int nx = sc.nextInt();
                int cost = sc.nextInt();
                adjList[st].add(new Edge(nx, cost));
                adjList[nx].add(new Edge(st, cost));
            }

            int ans = primMST();

            if(sets != 1)
                pw.println("IMPOSSIBLE");
            else
                pw.println(ans);
        }

        pw.flush();
        pw.close();
    }

    static class Edge implements Comparable<Edge>
    {
        int nxt, cost;

        public Edge(int nxt, int cost)
        {
            this.nxt = nxt;
            this.cost = cost;
        }

        public int compareTo(Edge e)
        {
            if(this.cost != e.cost)
                return this.cost - e.cost;
            return this.nxt - e.nxt;
        }
    }
}