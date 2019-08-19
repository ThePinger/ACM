//1118A
//BuyingWater

import java.io.PrintWriter;
import java.util.*;

public class BuyingWater
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int q = sc.nextInt();
        while(q-->0)
        {
            long n = sc.nextLong();
            int a = sc.nextInt();
            int b = sc.nextInt();
            long min = Long.MAX_VALUE;
            if(n % 2 == 0) 
                min = Math.min(n * a, (n / 2) * b);
            else 
                min = Math.min(n * a, ((n / 2) * b) + a);
            pw.println(min);
        }

        pw.flush();
        pw.close();
    }
}