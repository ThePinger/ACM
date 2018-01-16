//BinarySearch
import java.util.*;
import java.io.*;

public class InterestingDrink2
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int shops = sc.nextInt();
        int[] prices = new int[shops];

        for(int i = 0; i < shops; i++)
            prices[i] = sc.nextInt();
        
        Arrays.sort(prices);
        int queries = sc.nextInt();
        while(queries-->0)
        {
            int lo = 0;
            int hi = shops - 1;
            int coins = sc.nextInt();
            int poss = 0;
            while(lo <= hi)
            {
                int mid = (hi + lo) / 2;
                if(prices[mid] <= coins)
                {
                    lo = mid + 1;
                    poss = mid + 1;
                }
                else
                    hi = mid - 1;
                
            }
            sb.append(poss + "\n");
        }
        System.out.println(sb);
    }
}