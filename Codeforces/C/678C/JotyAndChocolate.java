//678C
//JotyAndChocolate

import java.util.*;

public class JotyAndChocolate
{

    public static long gcd(long n, long m)
    {
        return m == 0 ? n : gcd(m, n % m);
    }

    public static long lcm(long n, long m)
    {
        return n * (m / gcd(n, m));
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();
        long p = sc.nextInt();
        long q = sc.nextInt(); 
        long ans = ((n / a) * p) + ((n / b) * q) - ((n / lcm(a, b)) * Math.min(p, q));
        System.out.println(ans);   
    }
}