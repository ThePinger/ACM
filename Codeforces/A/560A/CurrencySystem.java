//560A
//Currency System

import java.util.Scanner;

public class CurrencySystem
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean found = false;
        
        while(n-->0)
            if(sc.nextInt() == 1)
                found = true;

        if(found)
            System.out.println(-1);
        else
            System.out.println(1);
    }
}