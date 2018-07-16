//543
//Goldbach's Conjecture

import java.io.*;
import java.util.*;

public class Main
{

    static int x, y;
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

    public static void getPrimes(int n)
    {
        for(int nxt : primes)
        {
            if(nxt * 2 > n) 
            {
                x = -1;
                y = -1;
                return;
            }

            int tmp = n - nxt;
            if(isPrime[tmp])
            {
                x = nxt;
                y = tmp;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        sieve(1000001);
        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            getPrimes(n);

            if(x == -1 && y == -1)
                pw.println("Goldbach's conjecture is wrong.");
            else
                pw.println(n + " = " + x + " + " + y);
        }

        pw.flush();
        pw.close();
    }
}