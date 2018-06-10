//10462
//Is There A Second Way Left?

import java.io.*;
import java.util.*;

public class Main
{
    static int disabled;
    static UnionFind uf;
    static ArrayList<Edge> edgeList;
    static ArrayList<Integer> taken;

    public static int kruskalMST()
    {
        int cost = 0;
        Collections.sort(edgeList);
        for(int i = 0; i < edgeList.size(); i++)
        {
            Edge edge = edgeList.get(i);
            if(!uf.isSameSet(edge.a, edge.b) && i != disabled)
            {
                if(disabled == -1) taken.add(i);
                cost += edge.cost;
                uf.union(edge.a, edge.b);
            }
        }
        return cost;
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

            uf = new UnionFind(n);
            edgeList = new ArrayList<>();
            taken = new ArrayList<>();

            for(int i = 0; i < m; i++)
                edgeList.add(new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));

            disabled = -1;
            kruskalMST();
            if(uf.getSets() != 1)
                pw.println("Case #" + c + " : No way");
            else
            {
                int min = Integer.MAX_VALUE;
                for(int i = 0; i < taken.size(); i++) 
                {
                    uf = new UnionFind(n);
                    disabled = taken.get(i);
                    int tmp = kruskalMST();
                    if(uf.getSets() != 1) continue;
                    min = Math.min(min, tmp);
                }

                if(min == Integer.MAX_VALUE)
                    pw.println("Case #" + c + " : No second way");
                else
                    pw.println("Case #" + c + " : " + min);
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