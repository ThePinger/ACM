//11876
//N + NOD (N)

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 1000001;
    static long[] freq;
    static int[] divisors;
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
                for(int j = i + i; j < N; j += i)
                    isPrime[j] = false;
            }
        }
    }

    public static int numDivisors(int x)
    {
        int div = 1;
        for(int p : primes)
        {
            if(p * p > x) break;
            int count = 0;
            while(x % p == 0)
            {
                x /= p;
                count++;
            }
            div *= count + 1;
        }
        if(x != 1) div *= 2;

        return div;
    }

    public static void computeSequence()
    {
        freq = new long[N];
        int pre = 1;
        while(pre < N)
        {
            freq[pre]++;
            pre = pre + divisors[pre];
        }   

        for(int i = 1; i < N; i++)
            freq[i] += freq[i - 1];
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        sieve();
        divisors = new int[N];
        for(int i = 1; i < N; i++) divisors[i] = numDivisors(i);
        computeSequence();
        for(int c = 1; c <= t; c++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pw.println("Case " + c + ": " + (freq[b] - freq[a - 1]));
        }

        pw.flush();
        pw.close();
    }
}