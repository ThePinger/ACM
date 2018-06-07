//10034
//Freckles

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main
{

    static UnionFind uf;
    static ArrayList<Edge> edgeList;

    public static double kruskalMST()
    {
        double cost = 0;
        Collections.sort(edgeList);
        for(int i = 0; i < edgeList.size(); i++)
        {
            Edge edge = edgeList.get(i);
            if(!uf.isSameSet(edge.a, edge.b))
            {
                cost += edge.cost;
                uf.union(edge.a, edge.b);
            }
        }
        return cost;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        for(int c = 0; c < t; c++)
        {
            if(c != 0) pw.println();

            int n = sc.nextInt();
            Pair[] pairs = new Pair[n];
            for(int i = 0; i < n; i++)
                pairs[i] = new Pair(sc.nextDouble(), sc.nextDouble());
        
            uf = new UnionFind(n);
            edgeList = new ArrayList<>();
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    if(i != j)
                        edgeList.add(new Edge(i, j, Math.sqrt(Math.pow(pairs[i].a - pairs[j].a, 2) + Math.pow(pairs[i].b - pairs[j].b, 2))));
            
            double cost = kruskalMST();
            DecimalFormat df = new DecimalFormat("0.00");
            pw.println(df.format(Math.round(cost * 100) / 100.0));
        }

        pw.flush();
        pw.close();
    }

    static class Pair
    {
        double a, b;

        public Pair(double a, double b)
        {
            this.a = a;
            this.b = b;
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
            if(this.cost > e.cost)
                return 1;
            else if(this.cost < e.cost)
                return -1;
            return 0;
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
            return i == parent[i] ? i : this.findSet(parent[i]);
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