//129A
//Cookies

import java.util.Scanner;

public class Cookies
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int odd = 0;
        int even = 0;
        
        while(n-->0)
        {
            if(sc.nextInt() % 2 == 0) even++;
            else odd++;
        }

        int ways = 0;
        if(odd % 2 != 0) ways = odd;
        else ways = even;

        System.out.println(ways);
    }
}