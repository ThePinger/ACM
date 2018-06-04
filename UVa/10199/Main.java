//10199
//Tourist Guide

import java.io.*;
import java.util.*;

public class Main
{

    static int dfsCounter, rootChildren, root;
    static int[] dfs_num, dfs_low, parent;
    static String[] locations;
    static boolean[] visited;
    static TreeSet<String> articulationPoints;
    static ArrayList<Integer>[] adjList;

    public static void findArticulationPoints(int cur)
    {
        visited[cur] = true;
        dfs_num[cur] = dfs_low[cur] = dfsCounter++;
        for(int nxt : adjList[cur])
        {
            if(!visited[nxt])
            {
                if(cur == root) rootChildren++;

                parent[nxt] = cur;

                findArticulationPoints(nxt);

                if(dfs_low[nxt] >= dfs_num[cur])
                    articulationPoints.add(locations[cur]);

                dfs_low[cur] = Math.min(dfs_low[cur], dfs_low[nxt]);
            }
            else if(nxt != parent[cur])
                dfs_low[cur] = Math.min(dfs_low[cur], dfs_num[nxt]);
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

            if(n == 0) break;
            if(t != 1) pw.println();

            locations = new String[n];
            TreeMap<String, Integer> map = new TreeMap<>();
            for(int i = 0; i < n; i++)
            {
                locations[i] = sc.next();
                map.put(locations[i], i);
            }

            dfsCounter = 0;
            dfs_num = new int[n];
            dfs_low = new int[n];
            parent  = new int[n];
            visited = new boolean[n];
            adjList = new ArrayList[n];
            articulationPoints = new TreeSet<>();

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            int conn = sc.nextInt();
            for(int i = 0; i < conn; i++)
            {
                String one = sc.next();
                String two = sc.next();
                adjList[map.get(one)].add(map.get(two));
                adjList[map.get(two)].add(map.get(one));
            }    
            
            for(int i = 0; i < n; i++)
            {
                if(!visited[i])
                {
                    root = i;
                    rootChildren = 0;
                    findArticulationPoints(i);
        
                    if(rootChildren < 2)
                        articulationPoints.remove(locations[i]);
                }
            }
                        
            pw.println("City map #" + (t++) + ": " + articulationPoints.size() + " camera(s) found");
            while(!articulationPoints.isEmpty())
                pw.println(articulationPoints.pollFirst());
        }

        pw.flush();
        pw.close();
    }
}