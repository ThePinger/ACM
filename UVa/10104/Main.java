//10104
//Euclid Problem

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
        
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int gcd = extendedEuclid(n, m);
            pw.println(x + " " + y + " " + gcd);
        }

        pw.flush();
        pw.close();
    }
}