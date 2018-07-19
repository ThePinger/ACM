//10139
//Factovisors

import java.io.*;
import java.util.*;

public class Main
{

    static boolean[] isPrime;
    static ArrayList<Integer> primes;
    static ArrayList<Pair> pairs;

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

    public static void primeFactors(int num)
    {
        pairs = new ArrayList<>();
        for(int p : primes)
        {
            if(p * p > num) break;
            int count = 0;
            while(num % p == 0)
            {
                count++;
                num /= p;
            }
            if(count > 0) pairs.add(new Pair(p, count));
        }

        if(num > 1) pairs.add(new Pair(num, 1));
    }

    public static boolean divides(int n)
    {
        for(Pair p : pairs)
        {
            long pow = p.prime;
            int count = 0;
            while(pow <= n)
            {
                count += n / pow;
                pow *= p.prime;
            }

            if(p.power > count)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        sieve(10000001);
        
        while(sc.ready())
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            primeFactors(m);
            if(m > 0 && divides(n))
                pw.println(m + " divides " + n + "!");
            else
                pw.println(m + " does not divide " + n + "!");
        }

        pw.flush();
        pw.close();
    }

    static class Pair
    {
        int prime, power;

        public Pair(int prime, int power)
        {
            this.prime = prime;
            this.power = power;
        }
    }

    static class Scanner 
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException 
        {
            while (st == null || !st.hasMoreTokens()) 
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}
        
        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}
        
        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }
        
        public boolean ready() throws IOException {return br.ready();}


    }
}