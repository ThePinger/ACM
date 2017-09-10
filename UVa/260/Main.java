//260
//Graphs

import java.io.*;
import java.util.*;

public class Main
{
  static int n;
	static int[] dx = new int[]{-1, 1, 0, 0, -1, 1};
	static int[] dy = new int[]{0, 0, -1, 1, -1, 1};
  static char[][] grid;
	static boolean valid(int i, int j)
	{
		return i != -1 && j != -1 && i != n && j != n;
	}

	static void dfs2(int i, int j)
	{
    char c = grid[i][j];
    if(grid[i][j] == 'b')
      grid[i][j] = 'x';
    else
      grid[i][j] = 'y';
		for(int k = 0; k < 6 ; ++k)
		{
			int x = i + dx[k], y = j + dy[k];
			if(valid(x, y) && grid[x][y] == c)
				dfs2(x, y);
		}
	}
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = 1;
    while(true)
    {
      n = Integer.parseInt(br.readLine());
      if(n == 0)
        break;
      grid = new char[n][n];
      for(int i = 0 ; i < n ; i++)
        grid[i] = br.readLine().toCharArray();
      for(int i = 0 ; i < n ; i++)
        if(grid[0][i] == 'b')
          dfs2(0,i);
      boolean f = false;
      for(int i = 0 ; i < n ; i++)
        if(grid[n-1][i] == 'x')
        {
          f = true;
          break;
        }
     if(f)
       System.out.println(t + " B");
     else
       System.out.println(t + " W");
     t++;
    }
  }
}
