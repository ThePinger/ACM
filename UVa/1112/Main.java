//1112
//Mice and Maze

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
        distance[start] = 0;
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
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int destination = sc.nextInt() - 1;
            int timer = sc.nextInt();
            int m = sc.nextInt();

            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < m; i++)
                adjList[sc.nextInt() - 1].add(new Edge(sc.nextInt() - 1, sc.nextInt()));

            int count = 0;
            for(int i = 0; i < n; i++)
            {
                distance = new int[n];
                dijkstra(i);
                if(distance[destination] <= timer)
                    count++;
            }

            pw.println(count);
            if(t != 0) pw.println();
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