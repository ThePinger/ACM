//413C
//Jeopardy

import java.util.*;

public class Jeopardy
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        int questions = sc.nextInt();
        int auction   = sc.nextInt();
        int[] points  = new int[questions];
        for(int i = 0; i < questions; i++)
            points[i] = sc.nextInt();
        
        int[] auctionSorted = new int[auction];
        for(int i = 0; i < auction; i++)
        {
            int idx = sc.nextInt() - 1;
            auctionSorted[i] = points[idx];
            points[idx] = 0;
        }
        Arrays.sort(auctionSorted);

        long score = 0;
        for(int i = 0; i < questions; i++)
            score += points[i];

        for(int i = auction - 1; i > -1; i--)
        {
            if(auctionSorted[i] < score)
                score += score;
            else
                score += auctionSorted[i];
        }

        System.out.println(score);

    }
}