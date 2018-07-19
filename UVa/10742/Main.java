//10742
//The New Rule in Euphomia

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 1000001;
    static int[] freq;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;

    public static void sieve()
    {
        freq = new int[N];
        isPrime = new boolean[N];
        primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i < N; i++)
        {
            if(isPrime[i])
            {
                freq[i]++;
                primes.add(i);
                if(1l * i * i > N) continue;
                for(int j = i * i; j < N; j += i)
                    isPrime[j] = false;
            }
        }

        for(int i = 1; i < N; i++)
            freq[i] += freq[i - 1];
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        sieve();

        int t = 1;
        while(true)
        {
            int x = sc.nextInt();

            if(x == 0) break;

            long ways = 0;
            for(int p : primes)
            {
                if(x < p) break;
                int tmp = x - p;
                if(tmp > p)
                    ways += freq[tmp] - freq[p];
            }

            pw.println("Case " + (t++) + ": " + ways);
        }

        pw.flush();
        pw.close();
    }
}