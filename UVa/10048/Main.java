//10048
//Audiophobia

import java.io.*;
import java.util.*;

public class Main
{

    static int destination;
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

    public static int dfs(int cur)
    {
        if(cur == destination)
            return 0;

        visited[cur] = true;
        for(Edge nxt : adjList[cur])
        {
            if(!visited[nxt.b])
            {
                int tmp = dfs(nxt.b);
                if(tmp > -1)
                    return Math.max(tmp, nxt.cost);
            }
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);  
        int t = 1;
        
        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();

            if(n == 0 && m == 0 && q == 0) break;

            uf = new UnionFind(n);
            visited = new boolean[n];
            adjList = new ArrayList[n];
            edgeList = new ArrayList<>();

            for(int i = 0; i < m; i++)
                edgeList.add(new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            if(t != 1) pw.println();
            pw.println("Case #" + (t++));

            kruskalMST();
            for(int i = 0; i < q; i++)
            {
                visited = new boolean[n];
                int start = sc.nextInt() - 1;
                destination = sc.nextInt() - 1;
                int ans = dfs(start);
                if(ans < 0) pw.println("no path");
                else pw.println(ans);
            }
        }

        pw.flush();
        pw.close();
    }

    static class Edge implements Comparable<Edge>
    {
        int a, b, cost;

        public Edge(int a, int b, int cost)
        {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Edge e)
        {
            return this.cost - e.cost;
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