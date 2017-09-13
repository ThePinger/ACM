//657
//The die is cast
//Graphs
//Floodfill

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main
{
  static int l;
  static int w;
  static int count;
  static char[][] grid;
  static int[] dx = new int[]{-1, 1, 0, 0};
  static int[] dy = new int[]{0, 0, -1, 1};
  static boolean valid(int i, int j)
  {
    return i != -1 && j != -1 && i != l && j != w;
  }

  static void dfs(int i, int j)
  {
    if(grid[i][j] == 'X')
    {
      count++;
      dfsX(i,j);
    }
    grid[i][j] = '.';
    for(int k = 0; k < 4 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y) && grid[x][y] != '.')
        dfs(x, y);
    }
  }

  static void dfsX(int i , int j)
  {

    grid[i][j] = '*';
    ArrayList<Point> arr = new ArrayList<>();
    for(int k = 0; k < 4 ; ++k)
    {
      int x = i + dx[k], y = j + dy[k];
      if(valid(x, y) && grid[x][y] == 'X')
        dfsX(x,y);
    }
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = 1;
    while(true)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      l = Integer.parseInt(st.nextToken());
      if(l == 0)
        break;
      count = 0;
      grid = new char[l][w];
      for(int i = 0 ; i < l ; i++)
        grid[i] = br.readLine().toCharArray();
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int i = 0 ; i < l ; i++)
        for(int j = 0 ; j < w ;j++)
           if(grid[i][j] != '.')
           {
             dfs(i,j);
             if(count > 0)
               pq.add(count);
             count = 0;
           }
      System.out.println("Throw " + t);
      int c = 1;
      while(!pq.isEmpty())
      {
        if(c == 1)
          System.out.print(pq.remove());
        else
          System.out.print(" " + pq.remove());
        c++;
      }
      System.out.println("");
      System.out.println("");
      t++;
    }
  }
}
