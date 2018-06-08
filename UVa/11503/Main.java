//11503
//Virtual Friends

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            UnionFindDisjointSets uf = new UnionFindDisjointSets(n * 2);
            TreeMap<String,Integer> map = new TreeMap<>();

            int count = 0;
            for(int i = 0; i < n; i++)
            {
                String a = sc.next();
                String b = sc.next();
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

                pw.println(uf.union(aa, bb));
            }
        }

        pw.flush();
        pw.close();
    }

    static class UnionFindDisjointSets
    {
        int sets;
        int[] rank, parent, setSize;

        public UnionFindDisjointSets(int size)
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

        public int union(int i, int j)
        {
            if(this.isSameSet(i, j))
                return this.getSetSize(i);
            
            sets--;
            int ii = this.findSet(i);
            int jj = this.findSet(j);
            if(rank[ii] > rank[jj])
            {
                parent[jj] = ii;
                setSize[ii] += setSize[jj];
                return this.setSize[ii];
            }
            else
            {
                parent[ii] = jj;
                setSize[jj] += setSize[ii];
                if(rank[ii] == rank[jj]) rank[jj]++;
                return this.setSize[jj];
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