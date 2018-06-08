import java.io.*;
import java.util.*;

public class ArticulationPointsAndBridges
{

    static int dfsCounter, rootChildren, root;
    static int[] dfs_num, dfs_low, parent;
    static boolean[] visited;
    static TreeSet<Integer> articulationPoints;
    static ArrayList<Integer>[] adjList;

    public static void findArticulationPointsAndBridges(int cur)
    {
        visited[cur] = true;
        dfs_num[cur] = dfs_low[cur] = dfsCounter++;
        for(int nxt : adjList[cur])
        {
            if(!visited[nxt])
            {
                //Root must have more than 2 Children 
                if(cur == root) rootChildren++;

                parent[nxt] = cur;

                findArticulationPointsAndBridges(nxt);

                if(dfs_low[nxt] >= dfs_num[cur])
                    articulationPoints.add(cur);

                if(dfs_low[nxt] > dfs_num[cur])
                    System.out.println("Bridge at edge " + cur + "--" + nxt);

                dfs_low[cur] = Math.min(dfs_low[cur], dfs_low[nxt]);
            }
            else if(nxt != parent[cur])
                dfs_low[cur] = Math.min(dfs_low[cur], dfs_num[nxt]);
        }
    }
}