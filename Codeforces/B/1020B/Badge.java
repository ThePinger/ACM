//1020B
//Badge

import java.util.*;

public class Badge
{

    static int n;
    static int[] nxt;
    static boolean[] vis;

    public static int dfs(int cur)
    {
        vis[cur] = true;
        return vis[nxt[cur]] ? nxt[cur] : dfs(nxt[cur]);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        nxt = new int[n];
        for(int i = 0; i < n; i++)
            nxt[i] = sc.nextInt() - 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            vis = new boolean[n];
            sb.append(dfs(i) + 1 + " ");
        }

        System.out.println(sb);
    }
}