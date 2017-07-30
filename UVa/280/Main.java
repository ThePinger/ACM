//280
//Vertex
//Graphs

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Main
{
  static ArrayList<Integer>[] adjList;
  static boolean[] vis;
  static int n;

  public static void dfs(int curNode)
  {
    for(int v: adjList[curNode])
			if(!vis[v])
      {
        vis[v] = true;
				dfs(v);
      }
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    while(n != 0)
    {
      adjList = new ArrayList[n];
      for (int i = 0; i < adjList.length; i++)
				adjList[i] = new ArrayList<Integer>();
      vis = new boolean[n];
      String[] s = br.readLine().split(" ");
      while(s.length != 1)
      {
        int v1 = Integer.parseInt(s[0])-1;
        for(int i = 1 ; i < s.length-1 ; i++)
        {
          int v2 = Integer.parseInt(s[i])-1;
          adjList[v1].add(v2);
        }
        s = br.readLine().split(" ");
      }
      s = br.readLine().split(" ");
      int num = Integer.parseInt(s[0]) ;
      for(int c = 1 ; c < num + 1 ; c++)
      {
        dfs(Integer.parseInt(s[c])-1);
        int cc = 0;
        String  line = "";
        for(int j = 0 ; j < vis.length ; j++)
        {
          if(!vis[j])
          {
            cc++;
            if(line.length() == 0)
               line = line +(j+1);
            else
               line = line + " " +(j+1);
          }
        }
        if(line.length() == 0)
          System.out.println(cc);
        else
          System.out.println(cc+" " + line);
        vis = new boolean[n];
      }
      n = Integer.parseInt(br.readLine());
    }
  }
}
