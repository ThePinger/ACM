//1097A
//Gennady And Card Game

import java.util.*;

public class CardGame
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String card = sc.next();
        for(int i = 0; i < 5; i++)
        {
            String cur = sc.next();
            if(card.charAt(0) == cur.charAt(0) || card.charAt(1) == cur.charAt(1))
            {
                System.out.println("YES");
                return;
            }
        }    

        System.out.println("NO");
    }
}