
//10443

import java.io.*;

public class Main
{
  static int n;
  static int m;
  static int[] dx = {0 , 0 , 1 , -1};
  static int[] dy = {1 , -1 , 0 , 0};
  static char[][] grid;
  public static boolean isValid(int row , int col)
  {
    return row != -1 && col != -1 && row != n && col != m;
  }
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while(t-->0)
    {
      String[] line = br.readLine().split(" ");
      int rows = Integer.parseInt(line[0]);
      int col = Integer.parseInt(line[1]);
      n = rows;
      m = col;
      int days = Integer.parseInt(line[2]);
      char[][] grid = new char[rows][col];
      for(int i = 0 ;i < rows ; i++)
         grid[i] = br.readLine().toCharArray();
      while(days-->0)
      {
         char[][] grid2 = new char[rows][col];
         for(int i = 0 ; i < rows ; i++)
         {
           for(int j = 0 ; j < col ; j++)
           {
             char c ;
             switch(grid[i][j])
             {
                 case 'R':c = 'P';break;
                 case 'S':c = 'R';break;
                 default :c = 'S';break;
              }
              for(int cc = 0 ; cc < 4 ; cc++)
              {
                int ii = i + dx[cc];
                int jj = j + dy[cc];
                if(isValid(ii,jj))
                  if(grid[ii][jj] == c)
                  {
                    grid2[i][j] = c;
                    break;
                  }
                  else
                    grid2[i][j] = grid[i][j];
                else
                    grid2[i][j] = grid[i][j];
              }
           }
         }
         grid = grid2;
        // for(char[] xx : grid)
        //  System.out.println(xx);
      }
      for(char[] xx : grid)
       System.out.println(xx);
      if(t != 0)
       System.out.println("");
    }
  }
}
