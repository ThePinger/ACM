//924
//Spreading News

import java.util.*;
import java.io.*;

public class Main
{
  static int max;
  static int day;
  static ArrayList<Integer>[] adjList;
  static boolean[] visited;
  public static void bfs(int s)
  {
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(s);
    visited[s] = true;
    max = adjList[s].size();
    day = 1;
    int curD = 1;
    int preS = 1;
    while(!q.isEmpty())
    {
      int vis = 0;
      while(preS-->0)
      {
        int u = q.remove();
        for(int v: adjList[u])
          if(!visited[v])
          {
            visited[v] = true;
            q.add(v);
            vis++;
          }
      }
      preS = vis;
      if(vis > max)
      {
        max = vis;
        day = curD;
      }
      curD++;
    }
  }
  public static void main(String[] args)throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int e = Integer.parseInt(br.readLine());
    adjList = new ArrayList[e];
    for(int i = 0 ; i < e ; i++)
      adjList[i] = new ArrayList<>();
    for(int i = 0 ; i < e ; i++)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken();
      while(st.hasMoreTokens())
        adjList[i].add(Integer.parseInt(st.nextToken()));
    }
    int t = Integer.parseInt(br.readLine());
    while(t-->0)
    {
      visited = new boolean[e];
      int src = Integer.parseInt(br.readLine());
      bfs(src);
      if(max == 0)
        System.out.println(0);
      else
        System.out.println(max + " " + day);
    }
  }
}
