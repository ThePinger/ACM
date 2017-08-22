//505C
//Treasure Hunter
//DP

import java.io.*;
import java.util.*;

public class Treasure
{
  static int[][] memo;
  static int[] gems;
  static int d;
  public static int dp(int isl , int prev)
  {
    int nxt = isl - prev;
    if(isl >= 30001)
      return 0;
    if(prev > isl)
      return 0;
    if(memo[isl][nxt - d + 500] != -1)
      return memo[isl][nxt - d + 500];
    int first = (int) -1e9;
    int middl = (int) -1e9;
    int lastt = (int) -1e9;
    if(nxt == 0)
      first = gems[isl] + dp(isl + nxt + 1 , isl);
    if(nxt == 1)
    {
      first = gems[isl] + dp(isl + nxt + 1 , isl);
      middl = gems[isl] + dp(isl + nxt , isl);
    }
    else
    {
      first = gems[isl] + dp(isl + nxt + 1 , isl);
      middl = gems[isl] + dp(isl + nxt , isl);
      lastt = gems[isl] + dp(isl + nxt - 1 , isl);
    }
    return memo[isl][nxt - d + 500] = Math.max(first , Math.max(middl , lastt));
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    d = Integer.parseInt(s[1]);
    gems = new int[30001];
    memo = new int[30001][1000];
    for(int[] cc : memo)
      Arrays.fill(cc , -1);
    for(int i = 0 ; i < n ; i++)
       gems[Integer.parseInt(br.readLine())]++;
    System.out.println(dp(d,0));
  }
}
