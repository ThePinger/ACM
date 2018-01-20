//11413
//Fill the Containers

import java.util.*;

public class Main
{
    static int containers, vessels;
    static int[] cap;

    public static boolean poss(long containerV)
    {
        long used = 0;
        long rem  = 0;
        for(int x : cap)
        {
            if(x > containerV) return false;
            if(x + rem > containerV)
            {
                rem = x;
                used++;
            }
            else
                rem += x;
        }
        
        if(rem != 0)
            used++;

        if(used > containers)
            return false;
        return true;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = 1;
        
        while(sc.hasNext())
        {
            if(t > 1) sb.append("\n");

            vessels = sc.nextInt();
            containers = sc.nextInt();
            cap = new int[vessels];

            long sum = 0;
            for(int i = 0; i < vessels; i++)
            {
                cap[i] = sc.nextInt();
                sum += cap[i];
            }

            long lo = 1;
            long hi = sum;
            long ans = 0;

            while(lo <= hi)
            {
                long mid = (hi + lo) / 2;
                if(poss(mid))
                {
                    hi = mid - 1;
                    ans = mid;
                }
                else
                    lo = mid + 1;
            }

            sb.append(ans);
            t++;
        }
        System.out.println(sb);
    }
}