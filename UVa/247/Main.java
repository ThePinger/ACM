//247
//Calling Circles

import java.io.*;
import java.util.*;

public class Main
{

    static int dfsCounter, scc;
    static int[] dfs_num, dfs_low;
    static boolean[] visited, inStack;
    static String[] values;
    static Stack<Integer> stack;
    static ArrayList<Integer>[] adjList;
    static PrintWriter pw = new PrintWriter(System.out);

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
                if(cur == child)
                {
                    pw.println(values[child]);
                    break;
                } 
                else
                    pw.print(values[child] + ", ");
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        
        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n == 0 && m == 0) break;
            
            if(t != 1) pw.println();
            
            pw.println("Calling circles for data set " + (t++) + ":");

            scc = 0;
            dfsCounter = 0;
            dfs_num = new int[n];
            dfs_low = new int[n];
            visited = new boolean[n];
            inStack = new boolean[n];
            values  = new String[n];
            stack   = new Stack<>();
            adjList = new ArrayList[n];

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            int count = 0;
            TreeMap<String, Integer> map = new TreeMap<>();
            for(int i = 0; i < m; i++)
            {
                String a = sc.next();
                String b = sc.next();
                int aa, bb;
                if(map.containsKey(a))
                    aa = map.get(a);
                else
                {
                    aa = count;
                    map.put(a, aa);
                    values[aa] = a;
                    count++;
                }

                if(map.containsKey(b))
                    bb = map.get(b);
                else
                {
                    bb = count;
                    map.put(b, bb);
                    values[bb] = b;
                    count++;
                }

                adjList[aa].add(bb);
            }

            for(int i = 0; i < n; i++)
                if(!visited[i])
                    tarjanSCC(i);
        }

        pw.flush();
        pw.close();
    }
}