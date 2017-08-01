//10699
//Count factors
//prime factors
//sieve

import java.io.*;
import java.util.*;

public class Main
{
  static boolean[] isPrime;
  static ArrayList<Integer> primes;
  public static void sieve(int n)
  {
    primes = new ArrayList<Integer>();
    isPrime = new boolean[n+1];
    Arrays.fill(isPrime , true);
    isPrime[0] = isPrime[1] = false;
    for(int i = 2 ; i < n ; i++)
    {
      if(isPrime[i])
      {
        primes.add(i);
        for(int j = 2 * i ; j < n ; j+=i)
          isPrime[j] = false;
      }
    }
  }

  public static int countFactors(int n)
  {
    int factors = 0;
    int cur = primes.get(0);
    int i = 0;
    while(cur <= n && i < primes.size())
    {
      boolean f = true;
      while(n % cur == 0)
      {
        if(f)
         factors++;
        n /= cur;
        f = false;
      }
      f = true;
      cur = primes.get(++i);
    }
    return factors;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    sieve(1000000);
    while(n != 0)
    {
      System.out.println(n + " : " + countFactors(n));
      n = Integer.parseInt(br.readLine());
    }
  }
}
