//509A

import java.util.*;

public class TableMax
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][n];

    arr[0][0] = 1;
    for(int i = 0 ; i < n ; i++)
       for(int j = 0 ; j < n ; j++)
          if(j == 0)
          {
            if(i != 0)
              arr[i][j] = arr[i-1][j];
          }
          else
          {
            if(i != 0)
              arr[i][j] = arr[i-1][j] + arr[i][j-1];
            else
              arr[i][j] = arr[i][j-1];
          }

    System.out.println(arr[n-1][n-1]);
  }
}
