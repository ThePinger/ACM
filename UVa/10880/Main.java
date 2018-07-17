//10880
//Colin and Ryan

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        for(int c = 1; c <= t; c++)
        {
            pw.print("Case #" + c + ":");
            int co = sc.nextInt();
            int r = sc.nextInt();
            int n = co - r;
            Stack<Integer> divisors = new Stack<>();
            for(int i = 1; i * i <= n; i++)
            {
                if(n % i == 0)
                {
                    if(i > r)
                        pw.print(" " + i);
                    if(n / i != i && n / i > r)
                        divisors.push(n / i);
                }
            }

            while(!divisors.isEmpty())
                pw.print(" " + divisors.pop());

            if(n == 0) pw.print(" 0");
            
            pw.println();
        }

        pw.flush();
        pw.close();
    }
}