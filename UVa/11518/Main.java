//11518
//Dominos2

import java.io.*;
import java.util.*;

public class Main
{

    static int count;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static void dfs(int cur)
    {
        count++;
        visited[cur] = true;
        for(int nxt : adjList[cur])
            if(!visited[nxt])
                dfs(nxt);
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
            int l = sc.nextInt();

            count = 0;
            visited = new boolean[n];
            adjList = new ArrayList[n];

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < m; i++)
                adjList[sc.nextInt() - 1].add(sc.nextInt() - 1);

            for(int i = 0; i < l; i++)
            {
                int tmp = sc.nextInt() - 1;
                if(!visited[tmp])
                    dfs(tmp);
            }

            pw.println(count);
        }

        pw.flush();
        pw.close();
    }
}
