//348A
//Mafia

import java.util.*;

public class Mafia
{
    static int n;
    static int[] nums;

    public static long getGames(long max)
    {
        long sum = 0;
        for(int i = 0; i < n; i++)
            sum += max - nums[i] * 1l;
        return sum;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        n   = sc.nextInt();
        nums = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }

        long lo = max;
        long hi = (long) 1e10;
        long ans = (long) 1e10;
        while(lo <= hi)
        {
            long mid = (lo + hi) / 2;
            long tmp = getGames(mid);
            if(tmp >= mid)
            {
                hi = mid - 1;
                ans = Math.min(ans, mid);
            }
            else
                lo = mid + 1;
        }

        System.out.println(ans);
    }
}