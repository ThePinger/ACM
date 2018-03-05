//227B
//EffectiveApproach

import java.util.*;

public class EffectiveApproach
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fromRight = new int[n + 1];
        int[] fromLeft  = new int[n + 1];
        
        for(int i = 1; i < n + 1; i++)
        {
            int num = sc.nextInt();
            fromRight[num] = i;
            fromLeft[num]  = n - i + 1;
        }

        long vasya = 0;
        long petya = 0;
        int q = sc.nextInt();
        while(q-->0)
        {
            int num = sc.nextInt();
            vasya += fromRight[num];
            petya += fromLeft[num];
        }

        sc.close();
        System.out.println(vasya + " " + petya);
    }
}