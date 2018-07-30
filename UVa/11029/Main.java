//11029
//Leading and Trailing

import java.io.*;
import java.util.*;

public class Main
{

    public static long modPow(long n, long k)
    {
        int mod = 1000;
        long ans = 1;
        while(k > 0)
        {
            if(k % 2 != 0)
                ans = (n * ans) % mod;
            n = ((n % mod) * (n % mod)) % mod;
            k /= 2;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = sc.nextInt();

        while(t-->0)
        {
            long n = sc.nextInt();
            long k = sc.nextInt();

            double pow = k * Math.log10(n);
            pow -= (int) pow;
            String first = ((long) (Math.pow(10, pow) * 1000.0)) + "";
            first = first.substring(0, 3);
            pw.print(first);
            pw.printf("...%03d\n", modPow(n, k));
        }

        pw.flush();
        pw.close();
    }
}