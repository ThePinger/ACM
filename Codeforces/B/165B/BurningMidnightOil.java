//165B
//Burning Midnight Oil

import java.util.*;

public class BurningMidnightOil
{
    static int n, k;

    public static int valid(int v)
    {
        int sum = 0;
        int i   = 0;
        while((int) Math.floor(v / Math.pow(k, i)) != 0)
        {
            sum += (int) Math.floor(v / Math.pow(k, i));
            i++;
        }

        if(sum == n)
            return 0;
        if(sum > n)
            return 1;
        return -1;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int lo = 1;
        int hi = n;
        int v  = 0;

        while(hi - lo != 1)
        {
            //v
            int mid = (lo + hi) / 2;
            int tmp = valid(mid);
            if(tmp == 0)
            {
                System.out.println(mid);
                return;
            }
            else if(tmp == -1)
                lo = mid;
            else
            {
                v = tmp;
                hi = mid;
            }
        }

        if(valid(lo) > -1)
            System.out.println(lo);
        else if(valid(hi) > -1)
            System.out.println(hi);
        else
            System.out.println(v);
    }
}