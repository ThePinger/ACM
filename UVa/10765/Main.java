//10765
//Doves and Bombs

import java.io.*;
import java.util.*;

public class Main
{

    static int dfsCounter, rootChildren, root;
    static int[] dfs_num, dfs_low, parent, children;
    static boolean[] visited, articulationPoints;
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
                {
                    articulationPoints[cur] = true;
                    children[cur]++;                
                }

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
        
        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n == 0 && m == 0) break;

            dfsCounter = 0;
            parent = new int[n];
            children = new int[n];
            dfs_low = new int[n];
            dfs_num = new int[n];
            visited = new boolean[n];
            articulationPoints = new boolean[n];
            adjList = new ArrayList[n];

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            while(true)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                
                if(a == -1 && b == -1) break;

                adjList[a].add(b);
                adjList[b].add(a);
            }

            int cc = 0;
            for(int i = 0; i < n; i++)
            {
                if(!visited[i])
                {
                    cc++;
                    root = i;
                    rootChildren = 0;
                    findArticulationPoints(i);
                    if(rootChildren < 2)
                    {
                        articulationPoints[i] = false;
                        children[i] = 0;
                    }
                }
            }
            
            PriorityQueue<Pair> set = new PriorityQueue<>();
            for(int i = 0; i < n; i++)
                set.add(new Pair(i, children[i] + cc));

            while(m-->0)
            {
                Pair tmp = set.poll();
                pw.println(tmp.station + " " + tmp.piegons);
            }

            pw.println();
        }
        
        pw.flush();
        pw.close();
    }

    static class Pair implements Comparable<Pair>
    {
        int station;
        int piegons;

        public Pair(int station, int piegons)
        {
            this.station = station;
            this.piegons = piegons;
        }

        public int compareTo(Pair p)
        {
            if(this.piegons != p.piegons)
                return p.piegons - this.piegons;
            return this.station - p.station;
        }
    }
}
