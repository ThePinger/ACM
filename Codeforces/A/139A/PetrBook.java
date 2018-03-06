//139A
//Petr and Book

import java.util.*;

public class PetrBook
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int pages = sc.nextInt();
        int[] week = new int[8];
        for(int i = 1; i < 8; i++)
            week[i] = sc.nextInt();

        int finalDay = 1;
        while(pages > 0)
        {
            if(week[finalDay] >= pages)
                pages = 0;
            else
            {
                pages -= week[finalDay];
                finalDay++;
                if(finalDay == 8)
                    finalDay = 1;
            }
        }
        System.out.println(finalDay);
    }
}
