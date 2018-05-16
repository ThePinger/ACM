//276A
//LunchRush

import java.util.*;

public class LunchRush
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int max = Integer.MIN_VALUE;
        
        while(n-->0)
        {
            int joy = sc.nextInt();
            int time = sc.nextInt();
            if(time > k)
                max = Math.max(max, joy - (time - k));
            else 
                max = Math.max(max, joy);
        }

        System.out.println(max);
    }
}