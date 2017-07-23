//357
//Let me count the ways
import java.io.*;
import java.util.Arrays;
public class Main
{
  static int[] coins;
  static long[][] visted;
  public static long waysN(int i ,int n)
  {
    if(n == 0)
      return 1;
    if(i == coins.length)
      return 0;
    if(visted[i][n] != -1)
      return visted[i][n];
    long ans = waysN(i+1,n);
    if(n - coins[i] >= 0)
      ans += waysN(i,n - coins[i]);
    return visted[i][n] = ans;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s ;
    coins = new int[]{1,5,10,25,50};
    visted = new long[5][30001];
    for(long xx[] : visted)
       Arrays.fill(xx,-1);
    while((s = br.readLine())!= null)
    {
      int n = Integer.parseInt(s);
      long a = waysN(0,n);
      if(a == 1)
        System.out.println("There is only 1 way to produce " + n + " cents change.");
      else
        System.out.println("There are " + a +" ways to produce "+ n +" cents change.");
    }
  }
}
