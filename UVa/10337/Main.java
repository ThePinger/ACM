//10337
//Flight Planner
//DP
import java.io.*;
import java.util.*;
public class Main
{
  static int[][] memo;
  static int[][] windSt;
  static int miles;
  public static int dp(int level , int milesRem)
  {
    if(level < 0 || level > 9)
      return (int) 1e9;
     if(milesRem == miles)
       if(level == 0)
         return 0;
       else
         return (int)1e9;
     if(memo[level][milesRem] != -1)
       return memo[level][milesRem];
     int st = windSt[level][milesRem];
     int up = 60 - st + dp(level + 1 , milesRem + 1);
     int hold = 30 - st + dp(level , milesRem + 1);
     int down = 20 - st + dp(level - 1 , milesRem + 1);
     return memo[level][milesRem] = Math.min(Math.min(up,hold),down);
  }
  public static void main(String[] args)throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n  = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < n ; i++)
    {
      br.readLine();
      miles = Integer.parseInt(br.readLine())/100;
      memo = new int[10][miles];
      windSt = new int[10][miles];
      for(int j = 9 ; j > -1 ; j--)
      {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int c = 0 ; c < miles ; c++)
          windSt[j][c] = Integer.parseInt(st.nextToken());
      }
      for(int[] yy : memo)
          Arrays.fill(yy , -1);
      System.out.println(dp(0,0));
      System.out.println("");
    }
  }
}
