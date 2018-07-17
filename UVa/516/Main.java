//516
//Prime Land

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 10000001;
    static int[] freq;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;
    static ArrayList<Pair> pairs;

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

    public static void primeFactors(long num)
    {
        for(int p : primes)
        {
            if(1l * p * p > num) break;
            int count = 0;
            while(num % p == 0)
            {
                count++;
                num /= p;
            }
            if(count > 0) pairs.add(new Pair(p, count));
        }

        if(num > 1) pairs.add(new Pair((int) num, 1));
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        sieve();

        loop : while(true)
        {
            long num = 1;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            while(st.hasMoreTokens())
            {
                int p = Integer.parseInt(st.nextToken());
                if(p == 0) break loop;
                int e = Integer.parseInt(st.nextToken());
                num *= Math.pow(p, e);
            }

            num--;
            pairs = new ArrayList<>();
            primeFactors(num);

            for(int i = pairs.size() - 1; i > -1; i--)
            {
                if(i == 0)
                    pw.println(pairs.get(i).p + " " + pairs.get(i).e);
                else
                    pw.print(pairs.get(i).p + " " + pairs.get(i).e + " ");                
            }
        }

        pw.flush();
        pw.close();
    }

    static class Pair
    {
        int p, e;

        public Pair(int p, int e)
        {
            this.p = p;
            this.e = e;
        }
    }
}