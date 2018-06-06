//11770
//LightingAway

import java.io.*;
import java.util.*;

public class Main
{

    static int dfsCounter, scc;
    static int[] dfs_num, dfs_low, numSCC;
    static boolean[] visited, inStack;
    static Stack<Integer> stack;
    static ArrayList<Integer>[] adjList;

    public static void tarjanSCC(int cur)
    {
        stack.push(cur);
        visited[cur] = true;
        inStack[cur] = true;
        dfs_low[cur] = dfs_num[cur] = dfsCounter++;

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

        if(dfs_num[cur] == dfs_low[cur])
        {
            scc++;
            while(true)
            {
                int child = stack.pop();
                inStack[child] = false;
                numSCC[child] = scc;
                if(cur == child) break;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        for(int c = 1; c <= t; c++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            scc = 0;
            dfsCounter = 0;
            dfs_num = new int[n];
            dfs_low = new int[n];
            numSCC  = new int[n];
            visited = new boolean[n];
            inStack = new boolean[n];
            stack   = new Stack<>();
            adjList = new ArrayList[n];

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < m; i++)
                adjList[sc.nextInt() - 1].add(sc.nextInt() - 1);

            for(int i = 0; i < n; i++)
                if(!visited[i])
                    tarjanSCC(i);

            boolean[] lighted = new boolean[scc + 1];
            Arrays.fill(lighted, true);

            for(int i = 0; i < n; i++)
                for(int nxt : adjList[i])
                    if(numSCC[i] != numSCC[nxt])
                        lighted[numSCC[nxt]] = false;

            int toBeLighted = 0;
            for(int i = 1; i <= scc; i++)
                if(lighted[i])
                    toBeLighted++;

            pw.println("Case " + c + ": " + toBeLighted);
        }
        
        pw.flush();
        pw.close();
    }
}