//12043
//Divisors

import java.io.*;
import java.util.*;

public class Main
{

    static final int N = 100001;
    static int[] sumDivisors, numDivisors;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;

    public static void sieve()
    {
        isPrime = new boolean[N];
        sumDivisors = new int[N];
        numDivisors = new int[N];
        primes  = new ArrayList<>();
        Arrays.fill(isPrime, true);
        Arrays.fill(sumDivisors, 1);
        Arrays.fill(numDivisors, 1);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i < N; i++)
        {
            if(isPrime[i])
            {
                primes.add(i);
                for(int j = i; j < N; j += i)
                {
                    isPrime[j] = false;
                    
                    int cur = j;
                    int count = 0;
                    int sum = 1;
                    while(cur % i == 0)
                    {
                        count++;
                        cur /= i;
                        sum += Math.pow(i, count);
                    }
                    
                    numDivisors[j] *= (count + 1);
                    sumDivisors[j] *= sum;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = sc.nextInt();

        sieve();

        while(t-->0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            long num = 0; long sum = 0;
            while(a <= b)
            {
                if(a % k == 0) 
                {
                    num += numDivisors[a];
                    sum += sumDivisors[a];
                }
                a++;
            }

            pw.println(num + " " + sum);
        }

        pw.flush();
        pw.close();
    }
}