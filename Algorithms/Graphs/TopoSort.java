
import java.util.*;

public class TopoSort
{
    static boolean[] visited;
    static Stack<Integer> topoSort;
    static ArrayList<Integer>[] adjList;

    public static void dfsTopoSort(int cur)
    {
        visited[cur] = true;
        for(int nxt : adjList[cur])
            if(!visited[nxt])
                dfsTopoSort(nxt);
        topoSort.push(cur);
    }
}