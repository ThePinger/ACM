//686A
//FreeIceCream

import java.util.*;

public class FreeIceCream
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long iceCream = sc.nextLong();
        int distress = 0;

        while(n-->0)
        {
            if(sc.next().equals("+")) iceCream += sc.nextLong();
            else
            {
                long order = sc.nextLong();
                if(order > iceCream) distress++;
                else iceCream -= order;
            }
        }

        System.out.println(iceCream + " " + distress);
    }
}