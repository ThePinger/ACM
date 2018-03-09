//688A
//Opponents

import java.util.Scanner;

public class Opponents
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int opp = sc.nextInt();
        int days = sc.nextInt();
        int maxCons = 0;
        int tmpCount = 0;

        for(int i = 0; i < days; i++)
        {
            int oppPresent = 0;
            char[] present = sc.next().toCharArray();
            for(int j = 0; j < present.length; j++)
                if(present[j] == '1')
                    oppPresent++;

            if(oppPresent == opp)
            {
                maxCons = Math.max(maxCons, tmpCount);
                tmpCount = 0;
            }
            else tmpCount++;
        }

        maxCons = Math.max(maxCons, tmpCount);
        System.out.println(maxCons);
    }
}
