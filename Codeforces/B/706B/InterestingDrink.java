
import java.util.*;
import java.io.*;

public class InterestingDrink
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int shops = sc.nextInt();
        int[] prices = new int[100001];

        for(int i = 0; i < shops; i++)
            prices[sc.nextInt()]++;

        for(int i = 1; i < prices.length; i++)
            prices[i] += prices[i-1];
            
        int queries = sc.nextInt();
        while(queries-->0)
        {
            int coins = sc.nextInt();
            if(coins > prices.length)
                sb.append(prices[prices.length - 1] + "\n");
            else
                sb.append(prices[coins] + "\n");
        }
        System.out.println(sb);
    }
}