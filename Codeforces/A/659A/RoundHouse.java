//659A
//Round House

import java.util.*;

public class RoundHouse
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        if(b == 0) System.out.println(a);
        else if(b > 0)
        {
            for(int i = 1; i < b + 1; i++)
                if(a == n) a = 1;
                else a++;
            System.out.println(a);
        }
        else
        {
            for(int i = 1; i < Math.abs(b) + 1; i++)
                if(a == 1) a = n;
                else a--;
            System.out.println(a);
        }
    }
}