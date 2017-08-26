//534B
//Covered Path
//DP

import java.io.*;
import java.util.*;

public class Speed
{
  static int start;
  static int finalS;
  static int seconds;
  static int change;
  static int[][] memo;
  public static int dp(int sec ,int speed)
  {
    if(speed <= 0) return (int) -1e9;
    if(sec == seconds - 1)
      if(speed == finalS)
        return finalS;
      else
        return (int) -1e9;
    if(memo[sec][speed] != -1)
      return memo[sec][speed];
    int inc = (int) -1e9;
    int dec = (int) -1e9;
    int ans = (int) -1e9;
    for(int i = 0 ; i < change + 1 ; i++)
    {
      inc = speed + dp(sec + 1 , speed + i);
      dec = speed + dp(sec + 1 , speed - i);
      ans = Math.max(ans , Math.max(inc , dec));
    }
    return memo[sec][speed] = ans;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    start = sc.nextInt();
    finalS = sc.nextInt();
    seconds = sc.nextInt();
    change = sc.nextInt();
    memo = new int[seconds][start+(change*seconds)+1];
    for(int[] xx : memo)
       Arrays.fill(xx , -1);
    System.out.println(dp(0,start));
  }
}
