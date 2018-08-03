
import java.util.*;

public class PrimeNumbers
{
    static boolean[] isPrime;
    static ArrayList<Integer> primes;
    static ArrayList<Pair> pairs;

    /*
        PRIME NUMBERS
     */

    // sieve(n) generates list of prime numbers from 0-->n
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

    /*
        PRIME FACTORIZATION
     */

    // primeFactors(num) gets all prime factors for num
    // Factors added in Array of Pairs (prime, power)
    public static void primeFactors(int num)
    {
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

    // numDivisors(x) counts the number of divisors of x
    public static int numDivisors(int x)
    {
        int div = 1;
        for(int p : primes)
        {
            if(p * p > x) break; // NO Divisor is greater than sqrt(x) except the x itself
            int count = 0;
            while(x % p == 0)
            {
                x /= p;
                count++;
            }
            div *= count + 1;
        }

        if(x != 1) div *= 2;

        return div;
    }

    public static int sumDivisors(int x)
    {
        int div = 1;
        for(int p : primes)
        {
            if(p * p > x) break; // NO Divisor is greater than sqrt(x) except the x itself
            int sum = 1;
            int count = 0;
            while(x % p == 0)
            {
                x /= p;
                count++;
                sum += Math.pow(p, count);
            }
            div *= sum;
        }

        if(x != 1) div *= 2;

        return div;
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
}