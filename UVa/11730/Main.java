//11730
//Number Transformation

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 1001;
    static final int oo = (int) 1e9;
    static int destination;
    static int[][] memo;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;
    static ArrayList<Integer>[] factors;

    public static int dp(int idx, int cur)
    {
        if(idx == factors[cur].size())
        {
            if(cur == destination)
                return 0;
            return oo;
        }

        if(memo[idx][cur] != -1)
            return memo[idx][cur];

        int take = oo, leave = dp(idx + 1, cur);
        int factor = factors[cur].get(idx);
        if(cur + factor <= destination)
            take = 1 + dp(0, cur + factor);
        
        return memo[idx][cur] = Math.min(take, leave);
    }

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

    public static void getFactors(int x, ArrayList<Integer> fact)
    {
        int copy = x;
        for(int p : primes)
        {
            if(p * p > copy) break;
            boolean flag = false;
            while(copy % p == 0 && p != x)
            {
                flag = true;
                copy /= p;
            }
            if(flag) fact.add(p);
        }

        if(copy > 1 && copy != x) fact.add(copy);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        sieve();

        int max = 0;
        factors = new ArrayList[N];
        for(int i = 1; i < N; i++)
        {
            factors[i] = new ArrayList<>();
            getFactors(i, factors[i]);
            max = Math.max(max, factors[i].size());
        }

        int t = 1;
        while(true)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x == 0 && y == 0) break;
            
            memo = new int[max][Math.max(x, y) + 1];
            for(int[] xx : memo)
                Arrays.fill(xx, -1);

            destination = y;
            int min = dp(0, x);
            pw.println("Case " + (t++) + ": " + (min >= oo ? -1 : min));
        }

        pw.flush();
        pw.close();
    }
}