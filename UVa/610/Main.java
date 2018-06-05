//610
//Street Directions

import java.io.*;
import java.util.*;

public class Main
{

    static int dfsCounter, rootChildren, root;
    static int[] dfs_num, dfs_low, parent;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static TreeSet<String> bridges;

    public static void findArticulationBridges(int cur)
    {
        visited[cur] = true;
        dfs_num[cur] = dfs_low[cur] = dfsCounter++;
        for(int i = 0; i < adjList[cur].size(); i++)
        {
            int nxt = adjList[cur].get(i);
            if(!visited[nxt])
            {
                parent[nxt] = cur;
                bridges.add((cur + 1) + " " + (nxt + 1));

                findArticulationBridges(nxt);

                if(dfs_low[nxt] > dfs_num[cur])
                    bridges.add((nxt + 1) + " " + (cur + 1));

                dfs_low[cur] = Math.min(dfs_low[cur], dfs_low[nxt]);
            }
            else if(nxt != parent[cur])
            {
                bridges.add((cur + 1) + " " + (nxt + 1));                
                dfs_low[cur] = Math.min(dfs_low[cur], dfs_num[nxt]);
                if(adjList[nxt].contains(cur))
                    adjList[nxt].remove(adjList[nxt].indexOf(cur));
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n == 0 && m == 0) break;

            dfsCounter = 0;
            dfs_low = new int[n];
            dfs_num = new int[n];
            parent  = new int[n];
            visited = new boolean[n];
            adjList = new ArrayList[n];
            bridges = new TreeSet<>();

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < m; i++)
            {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                adjList[a].add(b);
                adjList[b].add(a);
            }

            for(int i = 0; i < n; i++)
                if(!visited[i])
                    findArticulationBridges(i);

            pw.println(t++);
            pw.println();
            while(!bridges.isEmpty())
                pw.println(bridges.pollFirst());
            pw.println("#");
        }

        pw.flush();
        pw.close();
    }
}
