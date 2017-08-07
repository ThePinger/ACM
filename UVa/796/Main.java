//796
//Critical links
//Graphs
//Bridges
import java.io.*;
import java.util.ArrayList;
import java.awt.Point;
public class Main
{
  static ArrayList<Integer>[] adjList;
  static boolean[] vis;
  static ArrayList<Point> criticalLinks;
  static int[] num , low ;
  static int counter , root , rootChildren;
  static int[] parent;
  static void dfs(int u)
	{
    vis[u] = true;
		num[u] = low[u] = ++counter;
		for(int v: adjList[u])
			if(!vis[v])
			{
				parent[v] = u;
        if(u == root)
          rootChildren++;
        dfs(v);
				if(low[v] > num[u])
          criticalLinks.add(new Point(Math.min(u,v) , Math.max(u,v)));
				low[u] = Math.min(low[v], low[u]);
			}
			else
				if(parent[u] != v)
					low[u] = Math.min(low[u], num[v]);
	}
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(br.ready())
    {
      int n = Integer.parseInt(br.readLine());
      if(n == 0)
      {
        System.out.println("0 critical links");
        System.out.println("");
        if(br.ready())
          br.readLine();
        continue;
      }
      vis = new boolean[n];
      num = new int[n];
      low = new int[n];
      counter = -1;
      parent = new int[n];
      adjList = new ArrayList[n];
      criticalLinks = new ArrayList<Point>();
      for(int i = 0 ; i < n ; i++)
        adjList[i] = new ArrayList<>();
      String[] s = br.readLine().split(" ");
      while(s.length != 1)
      {
        int par = Integer.parseInt(s[0]);
        for(int i = 2 ; i < s.length ; i++)
        {
          int current = Integer.parseInt(s[i]);
          adjList[par].add(current);
          adjList[current].add(par);
        }
        s = br.readLine().split(" ");
      }
      for(int i = 0 ; i < n ; i++)
         if(!vis[i])
         {
           root = i;
           rootChildren = 0;
           dfs(i);
         }
      System.out.println(criticalLinks.size() + " critical links");
      for(int i = 0 ; i < criticalLinks.size() ; i++)
      {
        Point min = criticalLinks.get(i);
        for(int j = 0 ; j < criticalLinks.size() ; j++)
           if(criticalLinks.get(j).x < min.x)
             min = criticalLinks.get(j);
           else if(criticalLinks.get(j).x == min.x && criticalLinks.get(j).y < min.y)
             min = criticalLinks.get(j);
        System.out.println(min.x + " - " + min.y);
        criticalLinks.remove(min);
        i--;
      }
      System.out.println("");
    }
  }
}
