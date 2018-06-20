//20C
//Dijkstra

import java.util.*;

public class Dijkstra
{

    static long[] distance;
    static int[] parent;
    static ArrayList<Edge>[] adjList;

    public static void dijkstra(int start)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        Arrays.fill(distance, Long.MAX_VALUE);

        while(!pq.isEmpty())
        {
            Edge cur = pq.poll();
            if(cur.cost > distance[cur.node]) continue;
            for(Edge nxt : adjList[cur.node])
            {
                if(nxt.cost + cur.cost < distance[nxt.node])
                {
                    parent[nxt.node] = cur.node;
                    distance[nxt.node] = nxt.cost + cur.cost;
                    pq.add(new Edge(nxt.node, distance[nxt.node]));
                }
            }
        }
    }

    public static void printPath(int start)
    {
        Stack<Integer> stack = new Stack<>();
        while(true)
        {
            stack.push(start + 1); 
            start = parent[start];
            if(start == 0)
            {
                stack.push(1);
                break;
            }
        }
        
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        int m = sc.nextInt();

        distance = new long[n];
        parent = new int[n];
        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for(int i = 0; i < m; i++)
        {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int w = sc.nextInt();
            adjList[a].add(new Edge(b, w));
            adjList[b].add(new Edge(a, w));
        }

        dijkstra(0);
        if(distance[n - 1] != Long.MAX_VALUE)
            printPath(n - 1);
        else
            System.out.println(-1);
    }

    static class Edge implements Comparable<Edge>
    {
        int node;
        long cost;

        public Edge(int node, long cost)
        {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Edge e)
        {
            if(this.cost == e.cost)
                return this.node - e.node;
            return Long.compare(this.cost, e.cost);
        }
    }    
}