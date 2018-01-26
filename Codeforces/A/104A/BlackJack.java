//104A
//BlackJack

import java.util.*;

public class BlackJack
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n <= 10 || n > 21)
            System.out.println(0);
        else if(n - 10 == 10)
            System.out.println(15);
        else
            System.out.println(4);
   }
}