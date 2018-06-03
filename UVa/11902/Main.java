//11902
//Dominator

import java.beans.Visibility;
import java.io.*;
import java.util.*;

public class Main
{

    static int n, disable;
    static boolean[] visited, reachableFromZero;
    static boolean[][] dominates;
    static ArrayList<Integer>[] adjList;

    public static void dfs(int cur)
    {
        visited[cur] = true;
        for(int nxt : adjList[cur])
            if(!visited[nxt] && disable != nxt)
                dfs(nxt);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in); 
        PrintWriter pw = new PrintWriter(System.out); 
        int t = sc.nextInt();

        for(int i = 1; i <= t; i++)
        {
            n = sc.nextInt();
            visited = new boolean[n];
            reachableFromZero = new boolean[n];
            dominates = new boolean[n][n];
            adjList = new ArrayList[n];

            for(int j = 0; j < n; j++)
                adjList[j] = new ArrayList<>();

            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++)
                    if(sc.nextInt() == 1)
                        adjList[j].add(k);

            disable = -1;
            dfs(0);
            for(int j = 0; j < n; j++)
            {
                if(visited[j])
                {
                    reachableFromZero[j] = true;
                    dominates[0][j] = true;
                }
            }

            visited = new boolean[n];
            for(int j = 1; j < n; j++)
            {
                disable = j;
                dfs(0);
                for(int k = 0; k < n; k++)
                    if(!visited[k] && reachableFromZero[k])
                        dominates[j][k] = true;
                visited = new boolean[n];
            }

            pw.println("Case " + i + ":");
            pw.print("+");
            for(int j = 0; j < ((2 * n) - 1); j++) pw.print("-");
            pw.println("+");

            for(int j = 0; j < n; j++)
            {
                pw.print("|");
                for(int k = 0; k < n; k++)
                    if(dominates[j][k])
                        pw.print("Y|");
                    else
                        pw.print("N|");
                pw.println();
                pw.print("+");
                for(int l = 0; l < ((2 * n) - 1); l++) pw.print("-");
                pw.println("+");            
            }
        }

        pw.flush();
        pw.close();
    }
}

