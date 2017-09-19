//852
//Graphs
//Floodfill

import java.io.*;
import java.util.*;

public class Main
{
  static int score;
  static char cur_Char;
  static char[][] grid;
  static boolean[][] vis;
  static int[] dx = new int[]{-1, 1, 0, 0};
  static int[] dy = new int[]{0, 0, -1, 1};
  static boolean valid(int i, int j)
  {
    return i != -1 && j != -1 && i != 9 && j != 9 ;
  }

  static void dfs(int i, int j)
  {
    if(grid[i][j] == '.')
    {
      int ans = dfsX(i,j);
      if(ans > 0)
       score += ans ;
    }
    else
      score++;
    vis[i][j] = true;
    for(int k = 0; k < 4 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y) && (grid[x][y] == '.' || grid[x][y] == cur_Char) && !vis[x][y])
        dfs(x, y);
    }
  }

  static int dfsX(int i, int j)
  {
    vis[i][j] = true;
    int ans = 1;
    boolean f = true;
    for(int k = 0; k < 4 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y))
        if(grid[x][y] == '.' && !vis[x][y])
          ans += dfsX(x, y);
        else if(grid[x][y] != cur_Char && grid[x][y] != '.')
          f = false;
    }
    if(f)
     return ans;
    return (int) -1e9;
  }

  public static void main(String[] args)throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    while(n-->0)
    {
      grid = new char[9][9];
      vis = new boolean[9][9];
      int white = 0;
      int black = 0;
      score = 0;
      for(int i = 0 ; i < 9 ; i++)
        grid[i] = br.readLine().toCharArray();
      for(int i = 0 ; i < 9 ; i++)
        for(int j = 0 ; j < 9 ; j++)
           if(grid[i][j] == 'O' && !vis[i][j])
           {
             cur_Char = 'O';
             dfs(i,j);
             white += score;
             score = 0;
           }
           else if(grid[i][j] == 'X' && !vis[i][j])
           {
             cur_Char = 'X';
             dfs(i,j);
             black += score;
             score = 0;
           }
      System.out.println("Black " + black + " White " + white);
    }
  }
}
