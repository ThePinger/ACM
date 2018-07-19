//10892
//LCM Cardinality

import java.io.*;
import java.util.*;

public class Main
{

    static ArrayList<Integer> divisors;

    public static int gcd(int n, int m)
    {
        return m == 0 ? n : gcd(m, n % m);
    }

    public static int lcm(int n, int m)
    {
        return n * (m / gcd(n, m));
    }

    public static void listDivisors(int n)
    {
        divisors = new ArrayList<>();
        for(int i = 1; i * i <= n; i++)
        {
            if(n % i == 0)
            {
                divisors.add(i);
                if(n / i != i)
                    divisors.add(n / i);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            listDivisors(n);
            int count = 0;
            for(int i = 0; i < divisors.size(); i++)
                for(int j = i; j < divisors.size(); j++)
                    if(lcm(divisors.get(i), divisors.get(j)) == n)
                        count++;

            pw.println(n + " " + count);
        }

        pw.flush();
        pw.close();
    }
}