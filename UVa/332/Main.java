//332
//Rational Numbers from Repeating Fractions

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 10000001;
    static Queue<Integer>[] factors;
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

    public static void primeFactors(int num, int idx)
    {
        factors[idx] = new LinkedList<>();
        for(int p : primes)
        {
            if(1l * p * p > num) break;
            int count = 0;
            while(num % p == 0)
            {
                count++;
                num /= p;
                factors[idx].add(p);
            }
        }

        if(num > 1) factors[idx].add(num);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        sieve();

        int t = 1;
        while(true)
        {
            int j = sc.nextInt();

            if(j == -1) break;

            String s = sc.next();
            int k = s.length() - 2 - j;
            int p, q;
            if(j == 0)
            {
                String pp = "";
                String qq = "1";
                for(int i = 2; i < s.length(); i++)
                {
                    qq += "0";
                    pp += s.charAt(i);
                }   
                p = Integer.parseInt(pp);
                q = Integer.parseInt(qq);           
            }
            else
            {
                p = Integer.parseInt(s.substring(2));
                if(k > 0) p -= Integer.parseInt(s.substring(2, 2 + k));
                q = (int) (Math.pow(10, k + j) - Math.pow(10, k));
            }

            factors = new Queue[2];
            primeFactors(p, 0);
            primeFactors(q, 1);

            while(!factors[0].isEmpty() && !factors[1].isEmpty())
            {
                int topN = factors[0].peek();
                int topD = factors[1].peek();
                if(topN != topD)
                {
                    if(topN > topD)
                        factors[1].poll();
                    else
                        factors[0].poll();
                    continue;
                }
                factors[0].poll();
                factors[1].poll();
                p /= topN; q /= topN;
            }

            if(p == 0) pw.println("Case " + (t++) + ": 0/1");
            else pw.println("Case " + (t++) + ": " + p + "/" + q);
        }

        pw.flush();
        pw.close();
    }
}