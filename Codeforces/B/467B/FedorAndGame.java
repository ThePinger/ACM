//467B
//Fedor and New Game

import java.util.*;

public class FedorAndGame
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int types = sc.nextInt();
        int players = sc.nextInt();
        int maxBits = sc.nextInt();
        int[] armies = new int[players];
        for(int i = 0; i < players; i++)
            armies[i] = sc.nextInt();
        
        int fedor = sc.nextInt();
        int possibleTeams = 0;
        for(int i = 0; i < players; i++)
        {
            int diffCount = 0;
            String s = Integer.toBinaryString(fedor ^ armies[i]);
            for(int j = 0; j < s.length(); j++)
                if(s.charAt(j) == '1')
                    diffCount++;

            if(diffCount <= maxBits)
                possibleTeams++;
        }
        System.out.println(possibleTeams);
    }
}