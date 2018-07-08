//731B
//CouponsAndDiscounts

import java.util.*;

public class CouponsAndDiscounts
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rem = 0;
        boolean flag = true;
        while(n-->0 && flag)
        {
            int tmp = sc.nextInt() - rem;
            rem = 0;
            if(tmp < 0) flag = false;
            if(tmp % 2 != 0) rem = 1;
            if(rem == 1 && n == 0) flag = false;
        }

        System.out.println(flag ? "YES" : "NO");
    }
}