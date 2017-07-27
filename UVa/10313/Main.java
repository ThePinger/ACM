//10313
//Pay the price
//DP

import java.io.*;
import java.util.Arrays;
public class Main
{
  static long[][][] memo;
  public static long ways(int min , int max , int rem)
  {
    if(rem == 0)
      return 1;
    if(min > max)
      return 0;
    if(memo[min][max][rem] != -1)
      return memo[min][max][rem];
    long ans = ways(min+1 , max , rem);
    if(rem - min >= 0)
      ans += ways(min , max , rem - min);
    return memo[min][max][rem] = ans;
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    memo = new long[301][301][301];
    for(long [][] cc : memo)
      for(long[] xx: cc)
        Arrays.fill(xx,-1);
    while(br.ready())
    {
      String[] s = br.readLine().split(" ");

      if(s.length == 1)
        System.out.println(ways(1,Integer.parseInt(s[0]),Integer.parseInt(s[0])));
      else if(s.length == 2)
      {
        int min =  Integer.parseInt(s[1]);
        if(min > 300)
          min = 300;
        System.out.println(ways(1,min,Integer.parseInt(s[0])));
      }
      else
      {
        int max = Integer.parseInt(s[2]);
        int min = Integer.parseInt(s[1]);
        if(max > 300)
          max = 300;
        if(min > 300)
          min = 300;
        long ans = 0;
        long pre = 0;
        if(min > 1)
        {
          long tmp = ways(1,min-1,Integer.parseInt(s[0]));
          ans = ans + tmp;
          pre = ans;
          ans = 0;
        }
        for(int i = min ; i < max + 1 ; i++)
        {
          long tmp = ways(1,i,Integer.parseInt(s[0]));
          ans += tmp - pre ;
          pre = tmp;
        }
        System.out.println(ans);
      }
    }
  }
}
