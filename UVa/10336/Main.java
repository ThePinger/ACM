//10336
//Rank the languages
//Graphs
//Floodfill

import java.io.*;
import java.util.*;

public class Main
{
  static int h;
  static int w;
  static char cur_Char;
  static char[][] grid;
  static int[] dx = new int[]{-1, 1, 0, 0};
  static int[] dy = new int[]{0, 0, -1, 1};

  static boolean valid(int i, int j)
  {
    return i != -1 && j != -1 && i != h  && j != w ;
  }

  static void dfs(int i, int j)
  {
    grid[i][j] = '*';
    for(int k = 0; k < 4 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y) && grid[x][y] == cur_Char)
        dfs(x, y);
    }
  }
  public static void main(String[] args)throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int c = 0 ; c < n ; c++)
    {
      String[] s = br.readLine().split(" ");
      h = Integer.parseInt(s[0]);
      w = Integer.parseInt(s[1]);
      grid = new char[h][w];
      int[] score = new int[26];
      for(int j = 0 ; j < h ; j++)
        grid[j] = br.readLine().toCharArray();
      for(int i = 0 ; i < h ; i++)
        for(int j = 0 ; j < w ; j++)
          if(grid[i][j] != '*')
          {
            cur_Char = grid[i][j];
            dfs(i,j);
            score[cur_Char - 97]++;
          }
      System.out.println("World #" + (c+1));
      boolean[] taken = new boolean[26];
      int max = 0;
      int index = 0;
      for(int i = 0 ; i < 26 ; i++)
      {
        for (int j = 0 ; j < 26 ; j++)
           if(score[j] > max && !taken[j])
           {
             max = score[j];
             index = j + 97;
           }
        if(max > 0)
        {
          System.out.println((char)index + ": " + max);
          taken[index - 97] = true;
          max = 0;
        }
        else
          break ;
      }
    }
  }
}
