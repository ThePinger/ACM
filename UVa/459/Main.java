//459
//Graph Connectivity

import java.io.*;
import java.util.*;

public class Main
{
  static ArrayList<Integer>[] adjList;
  static boolean[] visited;

  public static void dfs(int u)
	{
		visited[u] = true;
		for(int v: adjList[u])
			if(!visited[v])
				dfs(v);
   }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    br.readLine();
    int c = 0 ;
    while(t-->0)
    {
      int end = (br.readLine().charAt(0)) - 65 + 1;
      adjList = new ArrayList[end];
      visited = new boolean[end];
      for(int i = 0 ; i < end ; i++)
         adjList[i] = new ArrayList<Integer>();
      String s;
      while(br.ready() && !(s=br.readLine()).isEmpty() )
      {
          int node1 = (s.charAt(0)) - 65;
          int node2 = (s.charAt(1)) - 65;
          adjList[node1].add(node2);
          adjList[node2].add(node1);
      }
      int ans = 0;
      for(int i = 0 ; i < end ; i++)
        if(!visited[i])
        {
          dfs(i);
          ans++;
        }
      if(c != 0)
        System.out.println("");
      System.out.println(ans);
      c++;
    }
  }
}
