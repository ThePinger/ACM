//588A
//DuffAndMeat

import java.util.*;

public class DuffAndMeat
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            int kg = sc.nextInt();
            min = Math.min(min, sc.nextInt());
            ans += kg * min;
        }

        System.out.println(ans);
    }
}