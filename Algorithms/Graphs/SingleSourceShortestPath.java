
import java.util.*;

public class SingleSourceShortestPath
{
    static int[] distance, parent;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static ArrayList<Edge>[] adjListEdge;

    // Unweighted Graphs
    public static void unweightedSSSP(int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty())
        {
            int cur = queue.poll();
            for(int nxt : adjList[cur])
            {
                if(!visited[nxt])
                {
                    queue.add(nxt);
                    visited[nxt] = true;
                    parent[nxt] = cur;
                    distance[nxt] = distance[cur] + 1;
                }
            }
        }
    }

    // Weighted Graphs
    public static void dijkstra(int start)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        Arrays.fill(distance, Integer.MAX_VALUE);

        while(!pq.isEmpty())
        {
            Edge cur = pq.poll();
            if(cur.cost > distance[cur.node]) continue;
            for(Edge nxt : adjListEdge[cur.node])
            {
                if(nxt.cost + cur.cost < distance[nxt.node])
                {
                    distance[nxt.node] = nxt.cost + cur.cost;
                    pq.add(new Edge(nxt.node, distance[nxt.node]));
                }
            }
        }
    }

    //BellmanFord
    //Graph with negative cycles
    public static boolean bellmanFord(int s)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        for(int i = 0; i < n - 1; i++)
            for(int j = 0; j < n; j++)
                if(dist[j] < Integer.MAX_VALUE)
                    for(Edge nxt : adjListEdge[j])
                        dist[nxt.node] = Math.min(dist[nxt.node], dist[j] + nxt.cost);

        //flag : Has Negative Cycle
        boolean flag = false;
        for(int i = 0; i < n; i++)
            for(Edge nxt : adjListEdge[i])
                if(dist[i] + nxt.cost < dist[nxt.node])
                    flag = true;

        return flag;
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