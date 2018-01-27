//246D
//ColorfulGraph

import java.util.*;

public class ColorfulGraph
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int vert = sc.nextInt();
        int edge = sc.nextInt();
        int[] colors = new int[vert];
        boolean[] vis = new boolean[100001];
        ArrayList<Integer>[] adjList = new ArrayList[100001];
        
        for(int i = 0; i < vert; i++)
        {
            colors[i] = sc.nextInt();
            vis[colors[i]] = true;
        }

        for(int i = 0; i < 100001; i++)
            adjList[i] = new ArrayList<>();

        for(int i = 0; i < edge; i++)
        {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            if(colors[x] != colors[y] && !adjList[colors[x]].contains(colors[y]))
            {
                adjList[colors[x]].add(colors[y]);
                adjList[colors[y]].add(colors[x]);
            }
        }

        int color = -1;
        int maxCa = -1;
        for(int i = 1; i < 100001; i++)
            if(adjList[i].size() > maxCa && vis[i])
            {
                color = i;
                maxCa = adjList[i].size();
            }
                   
        System.out.println(color);
    }
}