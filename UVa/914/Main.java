//914
//Jumping Champion

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 1000001;
    static boolean[] isPrime;
    static ArrayList<Integer> primes, diff;

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

    public static void generateDiff()
    {
        diff = new ArrayList<>();
        for(int i = 1; i < primes.size(); i++)
            diff.add(primes.get(i) - primes.get(i - 1));
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        sieve();
        generateDiff();

        int t = sc.nextInt();
        while(t-->0)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int maxSize = y - x + 1;
            
            boolean xx = false;
            for(int i = 0; i < primes.size(); i++)
            {
                int cur = primes.get(i);
                if(cur >= x)
                {
                    x = i;
                    xx = true;
                    break;
                }
            }

            boolean yy = false;
            for(int i = 0; i < primes.size(); i++)
            {
                int cur = primes.get(i);
                if(cur > y) 
                {
                    y = i - 1;
                    yy = true;
                    break;
                }
            }

            if(!xx) x = primes.size() - 1;
            if(!yy) y = primes.size() - 1;

            int[] freq = new int[maxSize];
            while(x < y)
                freq[diff.get(x++)]++;

            int max = 0;
            int maxIdx = -1;
            int count = 0;
            for(int i = 0; i < freq.length; i++)
                if(freq[i] > max)
                {
                    max = freq[i];
                    maxIdx = i;
                    count = 1;
                }            
                else if(freq[i] == max)
                    count++;

            if(max == 0 || count > 1)
                pw.println("No jumping champion");
            else 
                pw.println("The jumping champion is " + maxIdx);
        }

        pw.flush();
        pw.close();
    }
}