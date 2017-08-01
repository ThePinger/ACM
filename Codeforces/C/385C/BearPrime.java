//385C
//Bear and prime
//Math
import java.io.*;
import java.util.*;

public class BearPrime
{
  static int max = (int) 1e7 + 5;
  static boolean[] isPrime;
  static int[] frequency;
  static int[] count;
  public static void sieve(int n)
  {
    isPrime = new boolean[n+1];
    Arrays.fill(isPrime , true);
    isPrime[0] = isPrime[1] = false;
    for(int i = 2 ; i < n ; i++)
    {
      if(isPrime[i])
      {
        count[i] += frequency[i];
        for(int j = 2 * i ; j < n ; j+=i)
        {
          isPrime[j] = false;
          count[i] += frequency[j];
        }
      }
    }
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int n = Integer.parseInt(br.readLine());
    frequency = new int[max];
    isPrime = new boolean[max];
    count = new int[max];
    String[] s = br.readLine().split(" ");
    for(int i = 0 ; i < n ; i++)
       frequency[Integer.parseInt(s[i])]++;
    sieve(max);
    for(int i = 1 ; i < max ; i++)
       count[i] += count[i-1];
    int q = Integer.parseInt(br.readLine());
    while(q-->0)
    {
      s = br.readLine().split(" ");
      int l = Integer.parseInt(s[0]);
      int r = Integer.parseInt(s[1]);
      if(l > 1e7)
        pw.println(0);
      else
        pw.println(count[Math.min(r,max-1)] - count[l-1]);
    }
    pw.flush();
    pw.close();
  }
}
