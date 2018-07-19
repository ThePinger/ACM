//10673
//Play with Floor and Ceil

import java.io.*;
import java.util.*;

public class Main
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

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int gcd = extendedEuclid((n / k), (int) Math.ceil(n * 1.0 / k));
            pw.println((x * (n / gcd) + " " + (y * (n / gcd))));
        }

        pw.flush();
        pw.close();
    }
}