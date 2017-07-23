//147
//Dollars
//DP
import java.io.*;
import java.util.Arrays;
public class Main
{
  static int[] values;
  static long[][] pre;
  public static long ways(int i , int n)
  {
    if(n == 0)
      return 1;
    if(i == values.length)
      return 0;
    if(pre[i][n] != -1)
      return pre[i][n];
    long ans = ways(i+1,n);
    if(n - values[i] >= 0)
      ans += ways(i,n-values[i]);
    return pre[i][n] = ans;

  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int n = (int)Math.round(Double.parseDouble(s)*100);
    values = new int[]{5,10,20,50,100,200,500,1000,2000,5000,10000};
    pre = new long[11][30001];
    for(long [] yy : pre)
      Arrays.fill(yy,-1);
    while(n != 0)
    {
      for(int i = 0 ; i < 6 - s.length() ; i++)
        System.out.print(" ");
      System.out.print(s);
      String ans = "" + ways(0,n);
      for(int j = 0 ; j < 17 - ans.length() ; j++)
        System.out.print(" ");
      System.out.print(ans);
      System.out.println("");
      s = br.readLine();
      n = (int)Math.round(Double.parseDouble(s)*100);
    }
  }
}
