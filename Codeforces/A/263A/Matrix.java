//263A
//Beautiful Matrix

import java.io.*;

public class Matrix
{
  public static void main(String[] args)throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[][] grid = new String[5][5];
    for(int i = 0 ; i < 5 ; i++)
      grid[i] = br.readLine().split(" ");
    for(int i = 0 ; i < 5 ; i++)
      for(int j = 0 ; j < 5 ; j++)
         if(grid[i][j].equals("1"))
         {
           System.out.println(Math.abs(i-2) + Math.abs(j-2));
           return ;
         }
  }
}
