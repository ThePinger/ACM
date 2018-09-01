//1020A
//SISBuilding

import java.io.*;
import java.util.*;

public class SISBuilding
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int tow = sc.nextInt();
        int flo = sc.nextInt();
        int lo = sc.nextInt();
        int hi = sc.nextInt();
        int q = sc.nextInt();

        while(q-->0)
        {
            int t1 = sc.nextInt();
            int f1 = sc.nextInt();
            int t2 = sc.nextInt();
            int f2 = sc.nextInt();

            long ans = Math.abs(t1 - t2);
            if(t1 == t2) 
                ans = Math.abs(f1 - f2);
            else if(f1 < f2)
            {
                if(f1 > hi)
                    ans += (f1 - hi) + (f2 - hi);
                else if(f1 < lo)
                    ans += (lo - f1) + Math.abs(f2 - lo);
                else 
                    ans += f2 - f1;
            }
            else if(f1 > f2)
            {
                if(f1 < lo)
                    ans += (lo - f1) + (lo - f2);
                else if(f1 > hi)
                    ans += (f1 - hi) + Math.abs(f2 - hi);
                else 
                    ans += f1 - f2; 
            }
            else
            {
                if(f1 < lo)
                    ans += (lo - f1) + (lo - f2);
                else if(f1 > hi)
                    ans += (f1 - hi) + (f2 - hi);
            }
            pw.println(ans);
        }

        pw.flush();
        pw.close();
    }
}