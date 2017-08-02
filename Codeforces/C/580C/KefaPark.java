//Kefa and Park
//580C
//Graphs

import java.util.*;
import java.io.*;

public class KefaPark
{
  static ArrayList<Integer>[] graph;
  static boolean[] vis;
  static boolean[] cats;
  static boolean[] hasChild;
  static int res;
  static int maxC;

  public static int dfs(int curNode , int catsM)
  {
    vis[curNode] = true;
    if(cats[curNode])
       catsM++;
    else
       catsM = 0;
    if(catsM > maxC)
       return 0;
    int ans = 0;
    for(int i : graph[curNode])
    {
      if(!vis[i])
      {
        ans += dfs(i,catsM);
        hasChild[curNode] = true;
      }
    }
    if(!hasChild[curNode])
      return 1;
    return ans;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int v = Integer.parseInt(s[0]);
    maxC = Integer.parseInt(s[1]);
    graph = new ArrayList[v];
    cats = new boolean[v];
    vis = new boolean[v];
    hasChild = new boolean[v];
    s = br.readLine().split(" ");
    for(int i = 0 ; i < v ; i++)
    {
       graph[i] = new ArrayList<Integer>();
       if(s[i].equals("1"))
         cats[i] = true;
    }
    for(int i = 0 ; i < v -1 ; i++)
    {
      s = br.readLine().split(" ");
      int x = Integer.parseInt(s[0]);
      int y = Integer.parseInt(s[1]);
      graph[x-1].add(y-1);
      graph[y-1].add(x-1);
    }
    System.out.println(dfs(0,0));
  }
}
