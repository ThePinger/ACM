//10891
//Game of Sum
//DP

import java.io.*;
import java.util.*;

public class Main
{
  static long[][] memo;
  static ArrayList<Long> nums;

  public static long maxSum(int left , int right)
  {
    if(left > right)
      return 0;
    if(left == right)
      return nums.get(left);
    if(memo[left][right] != -1)
      return memo[left][right];
    long cur = 0;
    long ans = (long) -1e10;
    for(int i = left ; i <= right ; i++)
    {
      cur += nums.get(i);
      ans = Math.max(ans,cur - maxSum(i+1 , right));
    }
    cur = 0;
    for(int i = right ; i > left ; i--)
    {
      cur += nums.get(i);
      ans = Math.max(ans ,cur  - maxSum(left,i-1));
    }
    return memo[left][right] = ans;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    while(n != 0)
    {
      memo = new long[101][101];
      for(long[] xx : memo)
         Arrays.fill(xx , -1);
      String[] s = br.readLine().split(" ");
      nums = new ArrayList<Long>();
      for(String i : s)
         nums.add(Long.parseLong(i));
      System.out.println(maxSum(0,nums.size() - 1));
      n = Integer.parseInt(br.readLine());
    }
  }
}
