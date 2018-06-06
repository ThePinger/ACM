//11838
//Come and Go

import java.io.*;
import java.util.*;

public class Main
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

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n == 0 && m == 0) break;

            scc = 0;
            dfsCounter = 0;
            dfs_low = new int[n];
            dfs_num = new int[n];
            visited = new boolean[n];
            inStack = new boolean[n];
            stack   = new Stack<>();
            adjList = new ArrayList[n];

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < m; i++)
            {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int w = sc.nextInt();
                adjList[a].add(b);
                if(w == 2)
                    adjList[b].add(a);
            }

            for(int i = 0; i < n; i++)
                if(!visited[i])
                    tarjanSCC(i);

            if(scc == 1)
                pw.println(1);
            else 
                pw.println(0);
        }

        pw.flush();
        pw.close();
    }
}

