//11960
//Divisor Game

import java.io.*;
import java.util.*;

public class Main
{

    static boolean[] isPrime;
    static ArrayList<Integer> primes;

    public static void sieve(int n)
    {
        isPrime = new boolean[n];
        primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i < n; i++)
        {
            if(isPrime[i])
            {
                primes.add(i);
                if(1l * i * i >= n) continue;
                for(int j = i * i; j < n; j += i)
                    isPrime[j] = false;
            }
        }
    }

    public static int numDivisors(int x)
    {
        int div = 1;
        for(int p : primes)
        {
            if(p * p > x) break; // NO Divisor is greater than sqrt(x) except the x itself
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

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        sieve(1000001);

        int max = 1;
        int maxIDX = 1;
        int[] maxDivisors = new int[1000001];
        maxDivisors[1] = 1;
        for(int i = 2; i < 1000001; i++)
        {
            int tmp = numDivisors(i);
            if(tmp >= max)
            {
                maxDivisors[i] = i;
                maxIDX = i;
                max = tmp;
            }
            else
                maxDivisors[i] = maxIDX;
        }

        int t = sc.nextInt();
        while(t-->0)
            pw.println(maxDivisors[sc.nextInt()]);
        
        pw.flush();
        pw.close();
    }
}