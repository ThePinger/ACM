//1189A
//KeanuReeves

import java.util.*;

public class KeanuReeves
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String s = sc.next();
        int ones = 0;
        int zeroes = 0;
        for(int i = 0; i < n; i++)
            if(s.charAt(i) == '0')
                zeroes++;
            else ones++;

        if(zeroes == ones)
        {
            System.out.println(2);
            System.out.println(s.charAt(0) + " " + s.substring(1));
        }
        else
        {
            System.out.println(1);
            System.out.println(s);
        }
    }
}