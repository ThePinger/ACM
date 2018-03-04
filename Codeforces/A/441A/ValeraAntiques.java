//441A
//Valera and Antique Intems

import java.util.*;

public class ValeraAntiques
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int sellers = sc.nextInt();
        int money   = sc.nextInt();
        int i = 1;
        int enough = 0;
        
        while(sellers-->0)
        {
            int antiques = sc.nextInt();
            boolean bought = false;
            while(antiques-->0)
            {
                int tmp = sc.nextInt();
                if(money > tmp && !bought)
                {
                    enough++;
                    sb.append(i + " ");
                    bought = true;
                }
            }
            i++;
        }

        System.out.println(enough);
        System.out.println(sb);
    }
}