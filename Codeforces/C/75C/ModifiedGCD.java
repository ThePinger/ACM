//75C
//ModifiedGCD

import java.io.*;
import java.util.*;

public class ModifiedGCD
{

    public static int gcd(int n, int m)
    {
        return m == 0 ? n : gcd(m, n % m);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int gcd = gcd(sc.nextInt(), sc.nextInt());
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i = 1; i * i <= gcd; i++)
        {
            if(gcd % i == 0)
            {
                divisors.add(i);
                if(gcd / i != i)
                    divisors.add(gcd / i);
            }
        }

        Collections.sort(divisors);

        int q = sc.nextInt();
        while(q-->0)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int max = -1;
            for(int d : divisors)
                if(l <= d && r >= d)
                    max = d;
            pw.println(max);
        }

        pw.flush();
        pw.close();
    }
}