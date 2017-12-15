//750
//8 Queens
//Recursive Complete Search

import java.util.*;

public class Main
{
  static int row , col;
  static int line;
  static int[] rowB;
  static StringBuilder sb;

  public static boolean isValid(int column, int roww)
  {
    for(int i = 0 ; i < column ; i++)
      if(rowB[i] == roww || Math.abs(roww - rowB[i]) == Math.abs(column - i))
        return false;
    
    return true;
  }

  public static void place(int i)
  {
    if(i == 8 && rowB[col] == row)
    {
      if(line < 10) sb.append(" " + line + "      " + (rowB[0] + 1));
      else sb.append(line + "      " + (rowB[0] + 1));
      for(int j = 1 ; j < 8 ; j++) sb.append(" " + (rowB[j] + 1));
      sb.append("\n");
      line++;
    }

    for(int j = 0 ; j < 8 ; j++)
      if(isValid(i,j))
      {
        rowB[i] = j;
        place(i + 1);
      }
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    sb = new StringBuilder();
    int n = sc.nextInt();
    while(n-->0)
    {
      row = sc.nextInt() - 1;
      col = sc.nextInt() - 1;
      line = 1;
      sb.append("SOLN       COLUMN\n #      1 2 3 4 5 6 7 8\n\n");

      rowB = new int[8];
      place(0);
      if(n > 0) sb.append("\n");
    }
    System.out.print(sb);
  }
}
