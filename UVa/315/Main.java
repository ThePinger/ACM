//315
//Network
//Graphs

import java.io.*;
import java.util.*;

public class Main
{
  static ArrayList<Integer>[] adjList;
  //static TreeSet<Integer> articulationP;
  static boolean[] articulationP , vis;
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
				if(low[v] >= num[u])
					articulationP[u] = true;
				low[u] = Math.min(low[v], low[u]);
			}
			else
				if(parent[u] != v)
					low[u] = Math.min(low[u], num[v]);
	}

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    while(n != 0)
    {
       adjList = new ArrayList[n];
       //articulationP = new TreeSet<Integer>();
       articulationP = new boolean[n];
       num = new int[n];
       low = new int[n];
       for(int i = 0 ; i < n ; i++)
          adjList[i] = new ArrayList<>();
       String[] s = br.readLine().split(" ");
       int first = Integer.parseInt(s[0]);
       while(s.length != 1)
       {
         int parent = Integer.parseInt(s[0]);
         for(int i = 1 ;i < s.length ; i++)
         {
            adjList[parent-1].add(Integer.parseInt(s[i])-1);
            adjList[Integer.parseInt(s[i])-1].add(parent-1);
          }
         s = br.readLine().split(" ");
       }
       root = 0;
       rootChildren = 0;
       counter = -1;
       parent = new int[n];
       vis = new boolean[n];
       for(int i = 0 ; i < n ; i++)
          if(!vis[i])
          {
            root = i;
            rootChildren = 0;
            dfs(i);
            if(rootChildren < 2)
              articulationP[i] = false;
          }
        int c = 0;
        for(boolean i : articulationP)
           if(i)
             c++;
       System.out.println(c);
       n = Integer.parseInt(br.readLine());
    }
  }
}
