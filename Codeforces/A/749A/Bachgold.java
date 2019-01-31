//749A
//Bachgold Problem

import java.util.*;

public class Bachgold
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int twos = n / 2;
        int three = 0;
        if(n % 2 != 0)
        {
            twos--;
            three++;
        }

        System.out.println(twos + three);

        while(twos-->0) System.out.print("2 ");

        if(three > 0) System.out.println("3");
    }
}