//11709
//TrustGroups

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
        inStack[cur] = true;
        visited[cur] = true;
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
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            scc = 0;
            dfsCounter = 0;
            dfs_low = new int[n];
            dfs_num = new int[n];
            visited = new boolean[n];
            inStack = new boolean[n];
            stack   = new Stack<>();
            adjList = new ArrayList[n];
            TreeMap<String, Integer> map = new TreeMap<>();

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < n; i++)
            {
                String line = sc.nextLine();
                map.put(line, i);
            }

            for(int i = 0; i < m; i++)
            {
                int a = map.get(sc.nextLine());
                int b = map.get(sc.nextLine());
                adjList[a].add(b);
            }

            for(int i = 0; i < n; i++)
                if(!visited[i])
                    tarjanSCC(i);

            pw.println(scc);
        }

        pw.flush();
        pw.close();
    }
}


