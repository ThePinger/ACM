//217A
//Ice Skating

import java.util.*;

public class Skating
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
        int n = sc.nextInt();
        
        Pair[] coor = new Pair[n];
        for(int i = 0; i < n; i++)
            coor[i] = new Pair(sc.nextInt(), sc.nextInt());

        initializeSets(n);

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(i != j && (coor[i].a == coor[j].a || coor[i].b == coor[j].b))
                    union(i, j);

        System.out.println(sets - 1);
    }

    static class Pair
    {
        int a, b;
        
        public Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }
    }
}