//10305
//Ordering Task
//Graphs
//TopoSort

import java.io.*;
import java.util.*;

public class Main
{
  static ArrayList<Integer>[] nums;
  static boolean[] vis;
  static int[] inDegree;
  static ArrayList<Integer> topoSort;

  public static void dfs(int cur)
  {
    vis[cur] = true;
    topoSort.add(cur);
    for(int i = 0 ; i < nums[cur].size() ; i++)
    {
      int nxt = nums[cur].get(i);
      inDegree[nxt]--;
      if(inDegree[nxt] == 0)
        dfs(nxt);
    }
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int m = Integer.parseInt(s[1]);
    while(n != 0)
    {
        nums = new ArrayList[n];
        inDegree = new int[n];
        vis = new boolean[n];
        topoSort = new ArrayList<Integer>();
        for(int i = 0  ; i < n ; i++)
           nums[i] = new ArrayList<Integer>();
        for(int i = 0 ; i < m ; i++)
        {
          s = br.readLine().split(" ");
          int parent = Integer.parseInt(s[0]) - 1;
          int node = Integer.parseInt(s[1]) - 1;
          nums[parent].add(node);
          inDegree[node]++;
        }
        for(int i = 0 ; i < n ; i++)
        {
          if(!vis[i] && inDegree[i]==0)
            dfs(i);
        }
        for(int i = 0 ; i < topoSort.size() ; i++)
        {
          if(i+1 == topoSort.size())
            System.out.print((topoSort.get(i)+1));
          else
            System.out.print((topoSort.get(i)+1) + " ");
        }
        System.out.println("");
        s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
    }
  }
}
