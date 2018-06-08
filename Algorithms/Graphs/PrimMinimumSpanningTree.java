
import java.util.*;

public class PrimMinimumSpanningTree
{
    static int sets;
    static boolean[] taken;
    static ArrayList<Edge>[] adjList;
    static PriorityQueue<Edge> nxtEdges;

    public static int primMST()
    {
        int cost = 0;
        process(0);
        while(!nxtEdges.isEmpty())
        {
            Edge edge = nxtEdges.poll();
            if(!taken[edge.nxt])
            {
                sets--;
                process(edge.nxt);
                cost += edge.cost;
            }
        }
        return cost;
    }

    public static void process(int cur)
    {
        taken[cur] = true;
        for(Edge e : adjList[cur])
            nxtEdges.add(e);
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