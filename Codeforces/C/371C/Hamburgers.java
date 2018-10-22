//371C
//Hamburgers

import java.io.*;
import java.util.*;

public class Hamburgers
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        String sandwich = sc.next();
        long avBre = sc.nextLong();
        long avSau = sc.nextLong();
        long avChe = sc.nextLong();   
        long prBre = sc.nextLong();
        long prSau = sc.nextLong();
        long prChe = sc.nextLong();
        long money = sc.nextLong();

        long bread = 0;
        long saussage = 0;
        long cheese = 0;
        for(int i = 0; i < sandwich.length(); i++)
        {
            if(sandwich.charAt(i) == 'B')
                bread++;
            else if(sandwich.charAt(i) == 'S')
                saussage++;
            else cheese++;
        }

        long lo = 0;
        long hi = (long) 1e13;
        long ans = 0;
        while(lo <= hi)
        {
            long mid = (lo + hi) / 2;
            long b = bread * mid;
            long s = saussage * mid;
            long c = cheese * mid;
            b -= avBre; s -= avSau; c -= avChe;
            b = Math.max(0, b); s = Math.max(0, s); c = Math.max(0, c);
            long sum = b * prBre + s * prSau + c * prChe;
            if(sum <= money)
            {
                lo = mid + 1;
                ans = mid;
            }
            else hi = mid - 1;
        }

        System.out.println(ans);
    }
}