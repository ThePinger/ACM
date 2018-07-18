//10856
//Recover Factorial

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 2704000;
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

    public static int countFactors(int x)
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
        int pre = 0;
        int[] fact = new int[10001278];
        for(int i = 2; i < N; i++)
        {
            pre += countFactors(i);
            fact[pre] = fact[pre] == 0 ? i : fact[pre];
        }
        
        int t = 1;
        while(true)
        {
            int n = sc.nextInt();
            if(n < 0) break;
            pw.println("Case " + (t++) + ": " + (fact[n] == 0 && n != 0 ? "Not possible." : fact[n] + "!"));
        }

        pw.flush();
        pw.close();
    }
}