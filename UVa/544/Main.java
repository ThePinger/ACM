//544
//HeavyCargo

import java.io.*;
import java.util.*;

public class Main
{

    static int start, destination;
    static UnionFind uf;
    static boolean[] visited;
    static ArrayList<Edge> edgeList;
    static ArrayList<Edge>[] adjList;

    public static void kruskalMST()
    {
        Collections.sort(edgeList);
        for(int i = edgeList.size() - 1; i > -1; i--)
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
            return Integer.MAX_VALUE;

        visited[cur] = true;
        for(Edge nxt : adjList[cur])
        {
            if(!visited[nxt.b])
            {
                int tmp = dfs(nxt.b);
                if(tmp > -1)
                    return Math.min(tmp, nxt.cost);
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

            if(n == 0 && m == 0) break;

            uf = new UnionFind(n);
            visited = new boolean[n];
            adjList = new ArrayList[n];
            edgeList = new ArrayList<>();
            TreeMap<String,Integer> map = new TreeMap<>();

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            int count = 0;
            for(int i = 0; i < m; i++)
            {
                String a = sc.next();
                String b = sc.next();
                int cost = sc.nextInt();
                int aa, bb;

                if(map.containsKey(a))
                    aa = map.get(a);
                else
                {
                    aa = count++;
                    map.put(a, aa);
                }

                if(map.containsKey(b))
                    bb = map.get(b);
                else
                {
                    bb = count++;
                    map.put(b, bb);
                }

                edgeList.add(new Edge(aa, bb, cost));
            }

            start = map.get(sc.next());
            destination = map.get(sc.next());
            kruskalMST();
            int max = dfs(start);

            pw.println("Scenario #" + (t++));
            pw.println(max + " tons");
            pw.println();
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