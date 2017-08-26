//10891
//13Dots
//DP

import java.io.*;
import java.util.*;
import java.awt.*;
public class Main
{
  static int pocketMoney;
  static ArrayList<Point> items;
  static long[][] memo;
  static boolean f  = true;
  public static long dp(int i , int moneySpent)
  {
    if(moneySpent > pocketMoney + 200)
      return (long) -1e9;
    if(i == items.size())
    {
      if(moneySpent > 2000)
         moneySpent -= 200;
      if(moneySpent > pocketMoney)
         return (long) -1e9;
      return 0;
    }
    if(memo[i][moneySpent] != -1)
      return memo[i][moneySpent];
    long take = items.get(i).y + dp(i+1 , moneySpent + items.get(i).x);
    long leave = dp(i+1 , moneySpent);
    return memo[i][moneySpent] = Math.max(take,leave);
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(br.ready())
    {
      String[] s = br.readLine().split(" ");
      pocketMoney = Integer.parseInt(s[0]);
      int n = Integer.parseInt(s[1]);
      items = new ArrayList<>();
      memo = new long[n][pocketMoney+201];
      for(long[] nn : memo)
        Arrays.fill(nn , -1);
      while(n-->0)
      {
        s = br.readLine().split(" ");
        items.add(new Point(Integer.parseInt(s[0]) , Integer.parseInt(s[1])));
      }
      System.out.println(dp(0,0));
    }
  }
}
