//E
//VeggiesCount

import java.util.*;

public class E
{

    static final int N = 10000001;
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
                if(1l * i * i >= N) continue;
                for(int j = i * i; j < N; j += i)
                    isPrime[j] = false;
            }
        }
    }

    public static int countFactors(long x)
    {
        int factors = 0;
        for(int p : primes)
        {
            if(p * p > x) break;
            if(x % p == 0) 
            {
                while(x % p == 0) x /= p;
                factors++;
            }
        }

        if(x != 1) factors++;
        return factors;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        StringBuilder sb = new StringBuilder();
        sieve();
        int t = sc.nextInt();

        while(t-->0)
        {
            long n = sc.nextLong();
            sb.append(countFactors(n));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}