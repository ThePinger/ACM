//230B
//T - Primes

import java.io.*;
import java.util.*;

public class TPrimes
{

    public static boolean isPrime(int n)
    {
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        
        return true;
    }

    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[1000001];
        for(int i = 2; i < isPrime.length; i++)
            isPrime[i] = isPrime(i);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
        {
            long num = Long.parseLong(st.nextToken());
            int tmp = (int) Math.sqrt(num);
            if(isPrime[tmp] && (long) tmp * tmp == num)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }
        System.out.print(sb);
    }
}