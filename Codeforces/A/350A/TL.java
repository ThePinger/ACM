//350A
//TL

import java.util.Scanner;

public class TL
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int correct = sc.nextInt();
        int wrong   = sc.nextInt();
        
        int maxCorrect = Integer.MIN_VALUE;
        int minCorrect = Integer.MAX_VALUE;
        int maxWrong   = Integer.MIN_VALUE;
        int minWrong   = Integer.MAX_VALUE;

        while(correct-->0)
        {
            int tmp = sc.nextInt();
            maxCorrect = Math.max(maxCorrect, tmp);
            minCorrect = Math.min(minCorrect, tmp);
        }

        while(wrong-->0)
        {
            int tmp = sc.nextInt();
            maxWrong = Math.max(maxWrong, tmp);
            minWrong = Math.min(minWrong, tmp);
        }

        if(maxCorrect >= minWrong || minCorrect * 2 >= minWrong)
            System.out.println(-1);
        else 
            System.out.println(Math.max(minCorrect * 2, maxCorrect));
    }
}