//B
//One-Dimensional VolleyBall

import java.util.*;

public class B
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
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        
        while(t-->0)
        {
            long n = sc.nextInt();
            long a = sc.nextInt();
            long b = sc.nextInt();
            long ans = n / lcm(a, b);
            sb.append(ans + 1); sb.append("\n");
        }

        System.out.println(sb);
    }
}