//1113A
//SashaAndTrip

import java.util.*;

public class SashaAndTrip
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int v = sc.nextInt();

        int cur = Math.max((n - 1) - v, 0);
        int total = cur == 0 ? n - 1 : v;
        for(int i = 2; i < n; i++)
        {
           if(cur > 0)
           {
               cur--;
               total += i;
           }

        }
        System.out.println(total);
    }
}