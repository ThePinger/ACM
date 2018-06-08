//10608
//Friends

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
            int m = sc.nextInt();

            UnionFindDisjointSets uf = new UnionFindDisjointSets(n);
            for(int i = 0; i < m; i++)
                uf.union(sc.nextInt() - 1, sc.nextInt() - 1);

            pw.println(uf.maxSetSize);
        }

        pw.flush();
        pw.close();
    }

    static class UnionFindDisjointSets
    {
        int sets, maxSetSize;
        int[] rank, parent, setSize;

        public UnionFindDisjointSets(int size)
        {
            this.sets = size;
            this.maxSetSize = 1;
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
                this.maxSetSize = Math.max(this.maxSetSize, setSize[ii]);
            }
            else
            {
                parent[ii] = jj;
                setSize[jj] += setSize[ii];
                this.maxSetSize = Math.max(this.maxSetSize, setSize[jj]);
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
