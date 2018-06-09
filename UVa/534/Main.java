//534
//Frogger

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main
{
    static UnionFind uf;
    static boolean[] visited;
    static ArrayList<Edge> edgeList;
    static ArrayList<Edge>[] adjList;

    public static void kruskalMST()
    {
        Collections.sort(edgeList);
        for(int i = 0; i < edgeList.size(); i++)
        {
            Edge edge = edgeList.get(i);
            if(!uf.isSameSet(edge.a, edge.b))
            {
                uf.union(edge.a, edge.b);
                adjList[edge.a].add(new Edge(edge.a, edge.b, edge.cost));
                adjList[edge.b].add(new Edge(edge.b, edge.a, edge.cost));
            }
        }
    }

    public static double dfs(int cur)
    {
        if(cur == 1) return 0;
        visited[cur] = true;
        for(Edge nxt : adjList[cur])
        {
            if(!visited[nxt.b])
            {
                double tmp = dfs(nxt.b);
                if(tmp > -1)
                    return Math.max(tmp, nxt.cost);
            }
        }

        return -2;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        
        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            uf = new UnionFind(n);
            adjList = new ArrayList[n];
            visited = new boolean[n];
            edgeList = new ArrayList<>();
            Pair[] pairs = new Pair[n];

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < n; i++)
                pairs[i] = new Pair(sc.nextInt(), sc.nextInt());

            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    if(i != j)
                        edgeList.add(new Edge(i, j, Math.sqrt(Math.pow(pairs[i].x - pairs[j].x, 2) + Math.pow(pairs[i].y - pairs[j].y, 2))));

            kruskalMST();
            double max = dfs(0);
            DecimalFormat df = new DecimalFormat("#0.000");
            pw.println("Scenario #" + (t++));
            pw.println("Frog Distance = " + df.format(Math.round(max * 1000) / 1000.0));
            pw.println();
        }

        pw.flush();
        pw.close();
    }

    static class Pair
    {
        int x, y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>
    {
        int a, b;
        double cost;

        public Edge(int a, int b, double cost)
        {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge e)
        {
            return Double.compare(this.cost, e.cost);
        }

        public String toString()
        {
            return a + " " + " " + b + " " + cost;
        }
    }

    static class UnionFind
    {
        int sets;
        int[] rank, parent, setSize;

        public UnionFind(int size)
        {
            this.sets = size;
            this.rank = new int[size];
            this.parent = new int[size];
            this.setSize = new int[size];
            for(int i = 0; i < size; i++)
            {
                this.parent[i] = i;
                this.setSize[i] = 1;
            }
        }

        public int findSet(int i)
        {
            return i == parent[i] ? i : (parent[i] = this.findSet(parent[i]));
        }

        public boolean isSameSet(int i, int j)
        {
            return this.findSet(i) == this.findSet(j);
        }

        public void union(int i, int j)
        {
            if(this.isSameSet(i, j))
                return;
            
            sets--;
            int ii = this.findSet(i);
            int jj = this.findSet(j);
            if(rank[ii] > rank[jj])
            {
                parent[jj] = ii;
                setSize[ii] += setSize[jj];
            }
            else
            {
                parent[ii] = jj;
                setSize[jj] += setSize[ii];
                if(rank[ii] == rank[jj]) rank[jj]++;
            }
        }

        public int getSets()
        {
            return this.sets;
        }

        public int getSetSize(int i)
        {
            return this.setSize[this.findSet(i)];
        }
    }
}
