//115A
//Party

import java.util.*;

public class Party
{

    static boolean[] visited;
    static int[] graph;

    public static int dfs(int cur)
    {
        visited[cur] = true;
        int ans = 0;
        int nxt = graph[cur];
        if(!visited[nxt] && nxt != 0)
            ans = 1 + dfs(nxt);

        visited[cur] = false;
        return ans;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n + 1];
        graph = new int[n + 1];
        

        for(int i = 1; i < n + 1; i++)
        {
            int x = sc.nextInt();
            if(x == -1) continue;
            graph[i] = x;
        }

        int maxPath = 0;
        for(int i = 1; i < n + 1; i++)
            maxPath = Math.max(maxPath, dfs(i) + 1);

        System.out.println(maxPath);
    }
}