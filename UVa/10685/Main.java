//10685
//Nature

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n == 0 && m == 0) break;

            UnionFind uf = new UnionFind(n);
            TreeMap<String,Integer> map = new TreeMap<>();
            for(int i = 0; i < n; i++)
                map.put(sc.next(), i);

            for(int i = 0; i < m; i++)
                uf.union(map.get(sc.next()), map.get(sc.next()));

            pw.println(uf.maxSet);
        }

        pw.flush();
        pw.close();
    }

    static class UnionFind
    {
        int sets, maxSet;
        int[] rank, parent, setSize;

        public UnionFind(int size)
        {
            this.sets = size;
            this.maxSet = 1;
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
            return i == parent[i] ? i : findSet(parent[i]);
        }

        public boolean isSameSet(int i, int j)
        {
            return findSet(i) == findSet(j);
        }

        public void union(int i, int j)
        {
            if(isSameSet(i, j))
                return;

            this.sets--;
            int ii = findSet(i);
            int jj = findSet(j);
            if(this.rank[ii] > this.rank[jj])
            {
                this.parent[jj] = ii;
                this.setSize[ii] += this.setSize[jj];
                this.maxSet = Math.max(this.maxSet, this.setSize[ii]);
            }
            else
            {
                this.parent[ii] = jj;
                this.setSize[jj] += this.setSize[ii];
                this.maxSet = Math.max(this.maxSet, this.setSize[jj]);                
                if(this.rank[ii] == this.rank[jj]) this.rank[jj]++;
            }
        }
    }
}