//474B
//Worms

import java.util.*;

public class Worms
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] piles = new int[1000001];
        
        int last = 1;
        int curPile = 1;
        while(n-->0)
        {
            int tmp = sc.nextInt() + last;
            while(last < tmp)
                piles[last++] = curPile;
            
            curPile++;
        }

        int worms = sc.nextInt();
        while(worms-->0)
            sb.append(piles[sc.nextInt()] + "\n");
        
        System.out.print(sb);
    }
}