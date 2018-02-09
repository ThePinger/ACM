//750A
//New Year and Hurry

import java.util.*;

public class NewYearHurry
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int problems = sc.nextInt();
        int minutes  = sc.nextInt();
        
        int available = 240 - minutes;
        int ans = 0;

        int i = 1;
        while(available > 0 && ans < problems)
        {
            if(available - (5 * i)  >= 0) ans++;
            available -= (5  * i);
            i++;
        }

        System.out.println(ans);
    }
}