//490D
//Chocolate

import java.util.*;

public class Chocolate
{

    static long valA = 1, valB = 1;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;
    static TreeSet<Integer>[] primeFactors;
    static TreeMap<Integer, Integer>[] factors;

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

    public static void listFactors(int n, int idx)
    {
        factors[idx] = new TreeMap<>();
        primeFactors[idx] = new TreeSet<>();
        factors[idx].put(2, 0);
        factors[idx].put(3, 0);
        primeFactors[idx].add(2);
        primeFactors[idx].add(3);        
        for(int p : primes)
        {
            if(p * p > n && p > 3) break;
            while(n % p == 0)
            {
                n /= p;
                if(factors[idx].containsKey(p))
                    factors[idx].put(p, factors[idx].get(p) + 1);
                else 
                    factors[idx].put(p, 1);
                primeFactors[idx].add(p);
            }

            if(p == 3)
            {
                if(idx == 0 || idx == 1) valA *= n;
                else valB *= n;
            }
        }

        if(n > 1) 
        {
            factors[idx].put(n, 1);
            primeFactors[idx].add(n);
        }
    }

    public static int calculate(int idx)
    {
        int ans = 1;
        while(!primeFactors[idx].isEmpty())
        {
            int p = primeFactors[idx].pollFirst();
            ans *= (int) Math.pow(p, factors[idx].get(p));
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt(); int b1 = sc.nextInt();
        int a2 = sc.nextInt(); int b2 = sc.nextInt();
        
        sieve(10000001);

        factors = new TreeMap[4];
        primeFactors = new TreeSet[4];
        listFactors(a1, 0);
        listFactors(b1, 1);
        listFactors(a2, 2);
        listFactors(b2, 3);

        if(valA != valB)
            System.out.println(-1);
        else
        {
            long count = 0;
            int threeA1 = factors[0].get(3);
            int threeB1 = factors[1].get(3);
            int threeA2 = factors[2].get(3);
            int threeB2 = factors[3].get(3);
            int threeA = threeA1 + threeB1;
            int threeB = threeA2 + threeB2;

            while(threeA > threeB)
            {
                if(threeA1 > 0)
                {
                    threeA1--;
                    factors[0].put(3, threeA1);
                    factors[0].put(2, factors[0].get(2) + 1);
                }
                else
                {
                    threeB1--;
                    factors[1].put(3, threeB1);
                    factors[1].put(2, factors[1].get(2) + 1);
                }
                threeA--;
                count++;                
            }

            while(threeB > threeA)
            {
                if(threeA2 > 0)
                {
                    threeA2--;
                    factors[2].put(3, threeA2);
                    factors[2].put(2, factors[2].get(2) + 1);
                }
                else
                {
                    threeB2--;
                    factors[3].put(3, threeB2);
                    factors[3].put(2, factors[3].get(2) + 1);
                }
                threeB--;
                count++; 
            }

            int twoA1 = factors[0].get(2);
            int twoB1 = factors[1].get(2);
            int twoA2 = factors[2].get(2);
            int twoB2 = factors[3].get(2);
            int twoA = twoA1 + twoB1;
            int twoB = twoA2 + twoB2;

            while(twoA > twoB)
            {
                if(twoA1 > 0)
                {
                    twoA1--;
                    factors[0].put(2, twoA1);
                }
                else
                {
                    twoB1--;
                    factors[1].put(2, twoB1);
                }
                twoA--;
                count++;
            }

            while(twoB > twoA)
            {
                if(twoA2 > 0)
                {
                    twoA2--;
                    factors[2].put(2, twoA2);
                }
                else
                {
                    twoB2--;
                    factors[3].put(2, twoB2);
                }
                twoB--;
                count++;
            }

            a1 = calculate(0);
            b1 = calculate(1);
            a2 = calculate(2);
            b2 = calculate(3);
            System.out.println(count);
            System.out.println(a1 + " " + b1);
            System.out.println(a2 + " " + b2);
        }
    }
}