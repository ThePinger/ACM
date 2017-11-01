//11581

import java.util.*;
import java.io.*;

public class Main
{
  static int[][] grid;
  static int ones;
  static int[] ii = {0 , 0 , - 1 , 1};
  static int[] jj = {1 , - 1 , 0 , 0};

  public static boolean isValid(int row , int col)
  {
    return row != -1 && col != -1 && row != 3 && col != 3;
  }

  public static void switchGrid()
  {
    int one = 0;
    int[][] newgrid = new int[3][3];
    for(int i = 0 ; i < 3 ; i++)
    {
      for(int j = 0 ; j < 3 ;j++)
      {
        int sum = 0;
        for(int c = 0 ; c < 4 ; c++)
           if(isValid(i + ii[c] , j + jj[c]))
             sum += grid[i + ii[c]][j + jj[c]];
        newgrid[i][j] = sum % 2;
        if(newgrid[i][j] == 1)
          one++;
      }
    }
    ones = one;
    grid = newgrid;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    for(int cc = 0 ; cc < n ; cc++)
    {
      br.readLine();
      grid = new int[3][3];
      ones = 0;
      for(int i = 0 ; i < 3 ; i++)
      {
        char[] c = br.readLine().toCharArray();
        for(int j = 0 ; j < 3 ; j++)
        {
          grid[i][j] = Character.getNumericValue(c[j]);
          if(grid[i][j] == 1)
            ones++;
        }
      }

      if(ones == 0)
      {
        sb.append(-1 + "\n");
        continue;
      }

      int i = -1;
      while(ones > 0)
      {
        switchGrid();
        i++;
      }
      sb.append(i + "\n");
    }
    System.out.print(sb);
  }
}
