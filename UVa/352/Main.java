//352
//The Seasonal War
//Graphs
//Floodfill

import java.io.*;
import java.util.*;

public class Main
{
  static int n;
  static char[][] grid;
  static int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
  static int[] dy = new int[]{0, 0, -1, 1, -1, 1, 1, -1};
  static boolean valid(int i, int j)
  {
    return i != -1 && j != -1 && i != n && j != n;
  }

  static void dfs(int i, int j)
  {
    grid[i][j] = 'X';
    for(int k = 0; k < 8 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y) && grid[x][y] == '1')
        dfs(x, y);
    }
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = 1;
    while(br.ready())
    {
      n = Integer.parseInt(br.readLine());
      grid = new char[n][n];
      for(int i = 0; i < n ; i++)
        grid[i] = br.readLine().toCharArray();
      int eagle = 0;
      for(int i = 0 ; i < n ; i++)
        for(int j = 0 ; j < n ; j++)
           if(grid[i][j] == '1')
           {
             dfs(i,j);
             eagle++;
           }
      System.out.println("Image number " + t + " contains " + eagle + " war eagles.");
      t++;
    }
  }
}
