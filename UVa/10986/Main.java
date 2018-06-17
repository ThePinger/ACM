//10986
//Sending Email

import java.io.*;
import java.util.*;

public class Main
{

    static int[] distance;
    static ArrayList<Edge>[] adjList;

    public static void dijkstra(int start)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        Arrays.fill(distance, Integer.MAX_VALUE);

        while(!pq.isEmpty())
        {
            Edge cur = pq.poll();
            if(cur.cost > distance[cur.node]) continue;
            for(Edge nxt : adjList[cur.node])
            {
                if(nxt.cost + cur.cost < distance[nxt.node])
                {
                    distance[nxt.node] = nxt.cost + cur.cost;
                    pq.add(new Edge(nxt.node, distance[nxt.node]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        for(int c = 1; c <= t; c++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int start = sc.nextInt();
            int destination = sc.nextInt();

            distance = new int[n];
            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < m; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int co = sc.nextInt();
                adjList[a].add(new Edge(b, co));
                adjList[b].add(new Edge(a, co));
            }

            dijkstra(start);
            pw.println("Case #" + c + ": " + (distance[destination] == Integer.MAX_VALUE ? "unreachable" : distance[destination]));
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