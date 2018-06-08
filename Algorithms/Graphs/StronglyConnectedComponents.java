
import java.io.*;
import java.util.*;

public class StronglyConnectedComponents
{

    static int dfsCounter, scc;
    static int[] dfs_num, dfs_low;
    static boolean[] visited, inStack;
    static Stack<Integer> stack;
    static ArrayList<Integer>[] adjList;

    public static void tarjanSCC(int cur)
    {
        stack.push(cur);
        visited[cur] = true;
        inStack[cur] = true;
        dfs_num[cur] = dfs_low[cur] = dfsCounter++;

        for(int nxt : adjList[cur])
        {
            if(!visited[nxt])
            {
                tarjanSCC(nxt);
                dfs_low[cur] = Math.min(dfs_low[cur], dfs_low[nxt]);
            }
            else if(inStack[nxt])
                dfs_low[cur] = Math.min(dfs_low[cur], dfs_num[nxt]);
        }

        if(dfs_low[cur] == dfs_num[cur])
        {
            scc++;
            while(true)
            {
                int child = stack.pop();
                inStack[child] = false;
                if(cur == child) break;
            }
        }
    }
}