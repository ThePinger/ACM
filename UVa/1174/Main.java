//1174
//IPTV

import java.io.*;
import java.util.*;

public class Main
{

    static UnionFind uf;
    static ArrayList<Edge> edgeList;

    public static int kruskalMST()
    {
        int cost = 0;
        Collections.sort(edgeList);
        for(Edge edge : edgeList)
        {
            if(!uf.isSameSet(edge.a, edge.b))
            {
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
        
        for(int c = 0; c < t; c++)
        {

            if(c != 0 ) pw.println();

            int n = sc.nextInt();
            int m = sc.nextInt();

            int count = 0;
            uf = new UnionFind(n);
            edgeList = new ArrayList<>();
            TreeMap<String, Integer> map = new TreeMap<>();
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

            int ans = kruskalMST();
            pw.println(ans);
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