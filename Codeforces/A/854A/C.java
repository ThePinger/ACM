
import java.io.*;
import java.util.*;
public class C
{
  public static int gcd(int a, int b) {
   if (b==0) return a;
   return gcd(b,a%b);
}
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int sum = sc.nextInt();
    for(int n =  sum/2 ; n > 0 ; n--)
    {
      int d = sum - n;
      if(d == n)
        continue ;
      else
        if(gcd(d , n) == 1)
        {
          System.out.println(n + " " + d);
          break ;
        }
    }
  }
}
