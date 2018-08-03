

public class GCDLCM
{
    public static int gcd(int n, int m)
    {
        return m == 0 ? n : gcd(m, n % m);
    }

    public static int lcm(int n, int m)
    {
        return n * (m / gcd(n, m));
    }
}