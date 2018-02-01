//25D
//Roads not only in Berland

import java.awt.Point;
import java.util.*;

public class BerlandRoads
{
    static int sets;
    static boolean[] visited;
    static int[] parent, rank;
    static Queue<Point> closed;
    static Queue<Integer> isolated;

    public static void initializeSets(int size)
    {
        sets = size;
        parent = new int[size + 1];
        rank   = new int[size + 1];
        closed = new LinkedList<>();
        visited = new boolean[size + 1];
        Arrays.fill(visited, true);

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
        if(ii == jj)
        {
            closed.add(new Point(i, j));
            return;
        }

        sets--;
        if(rank[ii] > rank[jj])
        {
            parent[jj] = ii;
            visited[jj] = false;
        }
        else
        {
            parent[ii] = jj;
            visited[ii] = false;
            if(rank[ii] == rank[jj]) rank[jj]++;
        }
    }

    public static void getIsolated()
    {
        isolated = new LinkedList<>();
        for(int i = 1; i < visited.length; i++)
            if(visited[i])
                isolated.add(i);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        initializeSets(n);

        for(int i = 0; i < n - 1; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
        }

        getIsolated();
        System.out.println(sets - 1);
        
        while(sets > 1)
        {
            Point x = closed.poll();
            if(isSameSet(x.x, isolated.peek())) 
            {
                closed.add(x);
                isolated.add(isolated.poll());
            }
            else
            {
                union(x.x, isolated.peek());
                System.out.println(x.x + " " + x.y + " " + x.x + " " + isolated.poll());
            }
        }
    }
}