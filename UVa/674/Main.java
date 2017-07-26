//674
//Coin Change
//DP
import java.util.Scanner;
import java.util.Arrays;
public class Main
{
  static int[][] memo;
  static int[] coins;

  public static int ways(int i , int money)
  {
    if(money == 0)
      return 1;
    if(i == 5)
      return 0;
    if(memo[i][money] != -1)
      return memo[i][money];
    int ans = 0;
    if(money - coins[i] >= 0)
      ans += ways(i, money - coins[i]);
    ans += ways(i+1 , money);
    return memo[i][money] = ans;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    coins = new int[]{1,5,10,25,50};
    memo = new int[5][7490];
    for(int[] xx : memo)
      Arrays.fill(xx,-1);
    while(sc.hasNext())
    {
      int money = sc.nextInt();
      System.out.println(ways(0,money));
    }
  }
}
