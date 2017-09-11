//572
//Oil deposits
//Graphs
//Floodfill

import java.io.*;
import java.util.*;

public class Main
{
  static int n;
  static int m;
  static char[][] grid;
  static int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
  static int[] dy = new int[]{0, 0, -1, 1, -1, 1, 1, -1};
  static boolean valid(int i, int j)
  {
    return i != -1 && j != -1 && i != m && j != n;
  }

  static void dfs(int i, int j)
  {
    grid[i][j] = 'X';
    for(int k = 0; k < 8 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y) && grid[x][y] == '@')
        dfs(x, y);
    }
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      int deposits = 0;
      if(m == 0)
        break;
      grid = new char[m][n];
      for(int i = 0 ; i < m ; i++)
        grid[i] = br.readLine().toCharArray();
      for(int i = 0 ; i < m ; i++)
        for(int j = 0 ; j < n ;j++)
          if(grid[i][j] == '@')
          {
            deposits++;
            dfs(i,j);
          }
      System.out.println(deposits);
    }
  }
}
