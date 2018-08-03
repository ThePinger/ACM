

public class ExtendedEuclid
{
    static int x, y;

    public static int extendedEuclid(int n, int m)
    {
        if(m == 0)
        {
            x = 1;
            y = 0;
            return n;
        }

        int gcd = extendedEuclid(m, n % m);
        int xx = y;
        int yy = x - (n / m) * y;
        x = xx; 
        y = yy;
        
        return gcd;
    }
}