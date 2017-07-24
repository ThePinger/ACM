//11517
//ExcatChange
//DP
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
  static ArrayList<Integer> bills;
  static int[][] memo;
  static int[][] memo2;
  static int price;
  static int used;
  public static int paid(int i , int rem )
  {
    if(rem <= 0)
      return 0;
    if(i == bills.size())
    {
      if(rem > 0)
       return 60000;
      return 0;
    }
    if(memo[i][rem+10000] != -1)
      return memo[i][rem+10000];
    int take = 0 ;
    int leave = 0;
    take = bills.get(i) + paid(i+1 , rem - bills.get(i));
    leave = paid(i+1 , rem );
    return memo[i][rem+10000] = Math.min(take,leave);
  }

  public static int getCoins(int sum , int i)
  {
    if(sum < 0)
      return 600000;
    if(sum == 0)
      return 0;
    if(i == bills.size())
    {
      if(sum != 0)
        return 600000;
      return 0;
    }
    if(memo2[i][sum] != -1)
      return memo2[i][sum];
    int take = 0 ;
    int leave = 0;
    take = 1 + getCoins(sum - bills.get(i) , i+1);
    leave = getCoins(sum ,i+1);
    return memo2[i][sum] = Math.min(take,leave);
  }


  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < t ; i++)
    {
      used = 0;
      price = Integer.parseInt(br.readLine());
      int billsN = Integer.parseInt(br.readLine());
      bills = new ArrayList<Integer>();
      memo = new int[billsN][20001];
      memo2 = new int[billsN][20001];
      for(int j = 0 ; j < billsN ; j++)
        bills.add(Integer.parseInt(br.readLine()));
      for(int [] xx : memo)
        Arrays.fill(xx,-1);
      for(int [] yy : memo2)
        Arrays.fill(yy,-1);
      int sum = paid(0,price);
      System.out.println(sum +" "+ getCoins(sum , 0));
    }
  }
}
