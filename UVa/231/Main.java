//231
//Test the CATCHER

import java.io.*;
import java.util.*;

public class Main
{
  static int[][] memo;
  static ArrayList<Integer> missles;

  public static int dp(int idx , int maxHeight)
  {
    if(idx == missles.size())
      return 0;
    if(memo[idx][maxHeight] != -1)
      return memo[idx][maxHeight];
    int take = 0;
    int leave = 0;
    if(maxHeight == 0)
    {
      take = 1 + dp(idx+1 , missles.get(idx));
      leave = dp(idx+1 , 0);
    }
    else
    {
      if(missles.get(idx) > maxHeight)
        leave = dp(idx+1 , maxHeight);
      else
      {
        take = 1 + dp(idx+1 , missles.get(idx));
        leave = dp(idx+1 , maxHeight);
      }
    }
    return memo[idx][maxHeight] = Math.max(take , leave);
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int test = 1;
    while(true)
    {

      missles = new ArrayList<>();
      while(true)
      {
        int h = Integer.parseInt(br.readLine());
        if(h == -1)
          break;
        missles.add(h);
      }
      if(missles.size() == 0)
        break;
      if(test != 1)
        System.out.println("");
      memo = new int[missles.size()][32768];
      for(int[] xx : memo)
        Arrays.fill(xx,-1);
      System.out.println("Test #"+ test +":\n  maximum possible interceptions: "+dp(0,0));
      test++;
    }
  }
}
