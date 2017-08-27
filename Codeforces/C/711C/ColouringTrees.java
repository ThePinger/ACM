//711C
//Coloring Trees
//DP

import java.io.*;
import java.util.*;

public class ColouringTrees
{
  static int trees;
  static int colors;
  static int beauty;
  static int[][] cost;
  static long[][][] memo;
  static String[] treesColors;
  static final long oo = (long) 1e17;
  public static long dp(int tree , int pre , int curBeauty)
  {
    if(curBeauty > beauty) return oo;
    if(tree == trees)
      if(beauty == curBeauty)
        return 0;
      else
        return oo;
    if(memo[tree][pre][curBeauty] != -1)
      return memo[tree][pre][curBeauty];
    int curCol = Integer.parseInt(treesColors[tree]);
    long ans = oo;
    long nxt = oo;
    if(curCol == 0)
      for(int i = 0 ; i < colors ; i++)
      {
        if(tree == 0)
          nxt = cost[tree][i] + dp(tree + 1 , i , curBeauty + 1);
        else
          if(i == pre)
            nxt = cost[tree][i] + dp(tree + 1 , i , curBeauty);
          else
            nxt = cost[tree][i] + dp(tree + 1 , i , curBeauty + 1);
        ans = Math.min(ans , nxt);
      }
    else
      if(tree == 0)
        nxt = dp(tree + 1 , curCol - 1 , curBeauty + 1);
      else
        if(curCol == pre + 1)
          nxt = dp(tree + 1 , pre , curBeauty);
        else
          nxt = dp(tree + 1 , curCol - 1 , curBeauty + 1);
    ans = Math.min(nxt , ans);
    return memo[tree][pre][curBeauty] = ans;
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    trees = Integer.parseInt(st.nextToken());
    colors = Integer.parseInt(st.nextToken());
    beauty = Integer.parseInt(st.nextToken());
    treesColors = br.readLine().split(" ");
    cost = new int[trees][colors];
    memo = new long[trees][colors+1][beauty+1];
    for(int i = 0 ; i < trees ; i++)
    {
      st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j < colors ; j++)
         cost[i][j] = Integer.parseInt(st.nextToken());
    }
    for(long[][] xx : memo)
      for(long[] yy : xx)
        Arrays.fill(yy , -1);
    long ans = dp(0,0,0);
    if(ans >= oo)
      System.out.println(-1);
    else
      System.out.println(ans);
  }
}
