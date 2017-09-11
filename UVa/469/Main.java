//469
//Wetlands of florida
//Graphs
//Floodfill

import java.io.*;
import java.util.*;

public class Main
{
  static int n;
  static int m;
  static int count;
  static char[][] grid;
  static int[] dx = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
  static int[] dy = new int[]{0, 0, -1, 1, -1, 1, 1, -1};
  static boolean valid(int i, int j)
  {
    return i != -1 && j != -1 && i != n && j != m;
  }

  static void dfs(int i, int j)
  {
    grid[i][j] = 'X';
    count++;
    for(int k = 0; k < 8 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y) && grid[x][y] == 'W')
        dfs(x, y);
    }
  }

  static void dfsCorr(int i , int j)
  {
    grid[i][j] = 'W';
    for(int k = 0; k < 8 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y) && grid[x][y] == 'X')
        dfsCorr(x, y);
    }
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    br.readLine();
    int a = 1;
    while(t-->0)
    {
      if(a != 1)
        System.out.println("");
      grid = new char[100][100];
      boolean f = true;
      for(int i = 0 ; i < 1000000 ; i++)
      {
        String s = br.readLine();
        if(s == null || s.equals(""))
          break;
        if(s.charAt(0) != 'L' && s.charAt(0) != 'W')
        {
          if(f)
          {
            n = i;
            f = false;
          }
          String[] line = s.split(" ");
          dfs(Integer.parseInt(line[0])-1 , Integer.parseInt(line[1])-1);
          dfsCorr(Integer.parseInt(line[0])-1 , Integer.parseInt(line[1])-1);
          System.out.println(count);
          count = 0;
        }
        else
        {
          m = s.length();
          grid[i] = s.toCharArray();
        }
      }
      a++;
    }
  }
}
