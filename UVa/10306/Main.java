//10306
//e-coins
//DP

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.awt.Point;
public class Main
{
  static int[][] memo;
  static int ecoins;
  static ArrayList <Point> coins;
  static int min = 1000000;
  public static int minCoins(int i , int conv , int info)
  {
    if(ecoins == (conv*conv) + (info*info))
      return 0;
    if(i == coins.size() || ecoins < (conv*conv) + (info*info))
      return min;
    if(memo[conv][info] != -1)
      return memo[conv][info];
    int ans = 1 + minCoins(i , conv+coins.get(i).x , info+coins.get(i).y);
    int ans2  = minCoins(i+1 , conv , info);
    return memo[conv][info] = Math.min(ans , ans2);

  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    memo = new int[301][301];
    for(int i = 0 ; i < n ; i++)
    {
      if(i != 0)
        br.readLine();
      for(int[] yy : memo)
        Arrays.fill(yy , -1);
      String[] s = br.readLine().split(" ");
      int m = Integer.parseInt(s[0]);
      ecoins = (int)Math.pow(Integer.parseInt(s[1]),2);
      coins = new ArrayList<Point>();
      for(int j = 0 ; j < m ; j++)
      {
         s = br.readLine().split(" ");
         coins.add(new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
      }
      int ans = minCoins(0,0,0);
      if(ans == 0 || ans >= 1000000)
        System.out.println("not possible");
      else
        System.out.println(ans);
    }
  }
}
