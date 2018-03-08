//103B
//Cthulhu

import java.util.*;

public class Cthulhu
{
    static int nodes;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static void dfs(int cur)
    {
        nodes++;
        visited[cur] = true;
        for(int nxt : adjList[cur])
            if(!visited[nxt])
                dfs(nxt);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];

        if(n < 3 || n != m)
            System.out.println("NO");
        else
        {
            for(int i = 1; i < n + 1; i++)
                adjList[i] = new ArrayList<>();

            while(m-->0)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                adjList[x].add(y);
                adjList[y].add(x);
            }

            dfs(1);
            
            if(nodes == n) System.out.println("FHTAGN!");
            else System.out.println("NO");
        }
    }
}
