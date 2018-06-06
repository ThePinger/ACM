//11504
//Dominos

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
                numSCC[child]  = scc;
                if(cur == child) break;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            scc = 0;
            dfsCounter = 0;
            dfs_low = new int[n];
            dfs_num = new int[n];
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

            boolean[] pushed = new boolean[scc + 1];
            Arrays.fill(pushed, true);
            for(int i = 0; i < n; i++)
                for(int nxt : adjList[i])
                    if(numSCC[i] != numSCC[nxt])
                        pushed[numSCC[nxt]] = false;

            int toBePushed = 0;
            for(int i = 1; i < scc + 1; i++)
                if(pushed[i])
                    toBePushed++;

            pw.println(toBePushed);
        }
        
        pw.flush();
        pw.close();
    }
}