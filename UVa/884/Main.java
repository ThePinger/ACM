//884
//Factorial Factors

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 1000001;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;

    public static void sieve()
    {
        isPrime = new boolean[N];
        primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i < N; i++)
        {
            if(isPrime[i])
            {
                primes.add(i);
                if(1l * i * i > N) continue;
                for(int j = i * i; j < N; j += i)
                    isPrime[j] = false;
            }
        }
    }

    public static int countTerms(int x)
    {
        int count = 0;
        for(int p : primes)
        {
            if(p * p > x) break;
            while(x % p == 0)
            {
                x /= p;
                count++;
            }
        }

        if(x > 1) count++;

        return count;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        sieve();
        
        long[] ans = new long[N];
        for(int i = 2; i < N; i++)
            ans[i] += ans[i - 1] + countTerms(i);

        while(sc.hasNext())
            pw.println(ans[sc.nextInt()]);

        pw.flush();
        pw.close();
    }
}