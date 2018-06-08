
import java.util.*;

public class UnionFindDisjointSets
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