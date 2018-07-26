//A
//SaveMyWedding

import java.util.*;

public class A
{

    static ArrayList<Long> divisors = new ArrayList<>();

    public static void listDivisors(long n)
    {
        Stack<Long> stack = new Stack<>();
        for(long i = 1; i * i <= n; i++)
        {
            if(n % i == 0)
            {
                divisors.add(i);
                if(n / i != i)
                    stack.push(n / i);
            }
        }

        while(!stack.isEmpty())
            divisors.add(stack.pop());
    }

    public static boolean isPrime(long n)
    {
        if((n % 2 == 0 && n != 2) || n < 2) return false;
        for(long i = 3; i * i <= n; i += 2)
            if(n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        long n = sc.nextLong();
        listDivisors(n);
        long count = 0;
        for(int i = 0; i < divisors.size() - 1; i++)
        {
            long l = divisors.get(i);
            long r = divisors.get(i + 1);
            if(isPrime(r - l - 1))
                count++;
        }

        System.out.println(count);
    }
}