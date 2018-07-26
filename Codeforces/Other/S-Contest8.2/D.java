//D
//Don't Push on master!

import java.io.*;
import java.util.*;

public class D
{

    static final int N = 10000001;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;
    static Queue<Long> factors;

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

    public static void listFactors(long n)
    {
        factors = new LinkedList<>();
        for(int p : primes)
        {
            if(p * p > n) break;
            while(n % p == 0)
            {
                n /= p;
                factors.add(p * 1l);
            }
        }

        if(n > 1) factors.add(n);
    }

    public static boolean isPrime(long n)
    {
        if((n % 2 == 0 && n != 2) || n < 2) return false;
        for(long i = 3; i * i <= n; i += 2)
            if(n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        sieve();        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            long n = sc.nextLong();
            if((n < N && isPrime[(int) n]) || (n >= N && isPrime(n)))
            {
                sb.append("1 1\n");
                continue;
            } 

            listFactors(n);
            int count = 1;
            StringBuilder tmp = new StringBuilder(" 1");
            long last = n;
            while(!factors.isEmpty())
            {
                long top = factors.poll();
                if(last % top == 0 && last != top) 
                {
                    tmp.append(" " + (top * (n / last)));
                    count++;
                    last = last / top;
                }
            }
            sb.append(count); sb.append(tmp); sb.append("\n");
        }

        System.out.println(sb);
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