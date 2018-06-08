
import java.util.*;

public class DFS
{

    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static void dfs(int cur)
    {
        visited[cur] = true;
        for(int nxt : adjList[cur])
            if(!visited[nxt])
                dfs(nxt);
    }
}