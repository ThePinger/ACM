//10533
//Digit Primes

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 1000001;
    static long[] freq;
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

    public static void digitPrimes()
    {
        freq = new long[N];
        for(int p : primes)
            if(isDigitPrime(p))
                freq[p]++;

        for(int i = 1; i < N; i++)
            freq[i] += freq[i - 1];
    }

    public static boolean isDigitPrime(int p)
    {
        int sum = 0;
        String s = p + "";
        for(int i = 0; i < s.length(); i++)
            sum += Character.getNumericValue(s.charAt(i));
        return isPrime[sum];
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        sieve();
        digitPrimes();

        int t = sc.nextInt();
        while(t-->0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pw.println(freq[b] - freq[Math.max(0, a - 1)]);
        }

        pw.flush();
        pw.close();
    }
}