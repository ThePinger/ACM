
import java.util.*;

public class SingleSourceShortestPath
{
    static int[] distance, parent;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static ArrayList<Edge>[] adjListDijkstra;

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
            for(Edge nxt : adjListDijkstra[cur.node])
            {
                if(nxt.cost + cur.cost < distance[nxt.node])
                {
                    distance[nxt.node] = nxt.cost + cur.cost;
                    pq.add(new Edge(nxt.node, distance[nxt.node]));
                }
            }
        }
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