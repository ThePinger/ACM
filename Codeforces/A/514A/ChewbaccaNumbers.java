//514A
//Chewbacca and Number

import java.util.*;

public class ChewbaccaNumbers
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char[] number = sc.next().toCharArray();
        
        for(int i = 0; i < number.length; i++)
        {
            int x  = Character.getNumericValue(number[i]);
            if(i == 0 && x == 9)
                sb.append(9);
            else if(Math.abs(x - 9) < x)
                sb.append(Math.abs(x - 9)); 
            else
                sb.append(x);
        }

        System.out.println(sb);
    }
}