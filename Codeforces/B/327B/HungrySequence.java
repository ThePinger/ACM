//327B
//HungrySequence

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HungrySequence
{

    static ArrayList<Integer> primes;
    static boolean[] isPrime;

    public static void getPrimes(int n)
    {
        isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);
        primes = new ArrayList<>();

        for(int i = 2; i < isPrime.length && n > 0; i++)
        {
            if(isPrime[i]) 
            {
                System.out.print(i + " ");
                n--;                
            }
            else continue;

            for(int j = i + i; j < isPrime.length; j += i)
                isPrime[j] = false;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        getPrimes(n);
        System.out.println();
    }
}