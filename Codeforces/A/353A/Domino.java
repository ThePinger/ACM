//353A
//Domino

import java.util.*;

public class Domino
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oddUp = 0;
        int oddDown = 0;
        int bothOdd = 0;

        while(n-->0)
        {
            int cnt = 0;
            if(sc.nextInt() % 2 != 0)
            {
                oddUp++;
                cnt++;
            }

            if(sc.nextInt() % 2 != 0)
            {
                oddDown++;
                cnt++;
            }

            if(cnt == 2) bothOdd++;

        }
                        
        if(bothOdd > 0)
        {
            oddUp -= bothOdd;
            oddDown -= bothOdd;
        }

        if(oddDown == 0 && oddUp == 0 && bothOdd % 2 != 0) System.out.println(-1);
        else if((oddDown + oddUp) % 2 == 0)
        {
            if(bothOdd % 2 == 0)
            {
                if(oddDown % 2 != 0 || oddUp % 2 != 0)
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else
            {
                if(oddDown % 2 != 0 || oddUp % 2 != 0)
                    System.out.println(0);
                else
                    System.out.println(1);
            }
        }
        else System.out.println(-1);
        
    }
}