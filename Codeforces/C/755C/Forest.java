//755C
//PolandBall and Forest

import java.util.*;

public class Forest
{

    static int sets;
    static int[] parent, rank;

    public static void initializeSets(int size)
    {
        sets = size;
        parent = new int[size + 1];
        rank   = new int[size + 1];

        for(int i = 0; i < size + 1; i++) 
            parent[i] = i;
    }

    public static int findSet(int i)
    {
        if(parent[i] == i) return i;
        return findSet(parent[i]);
    }

    public static boolean isSameSet(int i, int j)
    {
        return findSet(i) == findSet(j);
    }

    public static void union(int i, int j)
    {
        int ii = findSet(i);
        int jj = findSet(j);
        if(ii == jj) return;

        sets--;
        if(rank[ii] > rank[jj])
            parent[jj] = ii;
        else
        {
            parent[ii] = jj;
            if(rank[ii] == rank[jj]) rank[jj]++;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        initializeSets(sc.nextInt());
        
        for(int i = 1; i < parent.length; i++)
            union(i, sc.nextInt());

        System.out.println(sets);
    }
}