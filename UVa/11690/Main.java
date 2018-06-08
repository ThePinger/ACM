//11690
//MoneyMatters

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

            for(int i = 0; i < n; i++) 
                uf.setMoney[i] = sc.nextInt();

            for(int i = 0; i < m; i++)
                uf.union(sc.nextInt(), sc.nextInt());

            if(uf.possible()) 
                pw.println("POSSIBLE");
            else
                pw.println("IMPOSSIBLE");
        }

        pw.flush();
        pw.close();
    }

    static class UnionFindDisjointSets
    {
        int sets;
        int[] rank, parent, setSize, setMoney;
        boolean[] curSets;

        public UnionFindDisjointSets(int size)
        {
            this.sets = size;
            this.rank = new int[size];
            this.parent = new int[size];
            this.setSize = new int[size];
            this.setMoney = new int[size];
            this.curSets = new boolean[size];
            for(int i = 0; i < size; i++)
            {
                this.parent[i] = i;
                this.setSize[i] = 1;
                this.curSets[i] = true;
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
                setMoney[ii] += setMoney[jj];
                curSets[jj] = false;
            }
            else
            {
                parent[ii] = jj;
                setSize[jj] += setSize[ii];
                setMoney[jj] += setMoney[ii];
                curSets[ii] = false;
                if(rank[ii] == rank[jj]) rank[jj]++;
            }
        }

        public boolean possible()
        {
            for(int i = 0; i < curSets.length; i++)
                if(curSets[i] && setMoney[i] != 0)
                    return false;
            return true;
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
