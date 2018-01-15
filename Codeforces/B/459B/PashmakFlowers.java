//459B
//Pashmak And Flowers

import java.util.*;

public class PashmakFlowers
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = 0;
        int min = Integer.MAX_VALUE;
        int maxCount = 0;
        int minCount = 0;
        for(int i = 0; i < n; i++)
        {
            int flower = sc.nextInt();
            if(flower > max)
            {
                max = flower;
                maxCount = 1;
            }
            else if(flower == max)
                maxCount++;
            
            if(flower < min)
            {
                min = flower;
                minCount = 1;
            }
            else if(flower == min)
                minCount++;
        }

        if(max == min)
            System.out.println(0 + " " + ((long) ((long) maxCount * (maxCount - 1)) / 2));
        else
            System.out.println((max - min) + " " + ((long) maxCount * minCount));
    }
}