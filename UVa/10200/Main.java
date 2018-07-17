//10200
//Prime Time

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 10000001;
    static int[] freq;
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

    public static boolean isPrime(int x)
    {
        if(x < N) return isPrime[x];
        for(int p : primes)
        {
            if(1l * p * p > x) break;
            if(x % p == 0)
                return false; 
        }
        return true;
    }

    public static void computeFormula()
    {
        freq = new int[10001];
        for(int i = 0; i < freq.length; i++)
            if(isPrime((i * i) + i + 41))
                freq[i]++;
        
        for(int i = 1; i < freq.length; i++)
            freq[i] += freq[i - 1];
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        sieve();
        computeFormula();

        while(sc.hasNext())
        {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int ans = freq[b];
            if(a > 0) ans -= freq[a - 1];

            pw.printf("%.2f\n", (ans / (b - a + 1.0) * 100.0));
        }

        pw.flush();
        pw.close();
    }
}