//812C
//Sagheer and Nubian Market

import java.util.*;

public class SagheerAndNubianMarket
{
    static int souvenirs, maxS;
    static long budget, minC;
    static long[] initialPrice;
    static PriorityQueue<Long> actualPrice;

    public static void calculatePrice(int k)
    {
        actualPrice = new PriorityQueue<>();
        for(int i = 1; i < initialPrice.length; i++)
            actualPrice.add(initialPrice[i] + ((long)i * k));
    }

    public static long getCost(int k)
    {
        long ans = 0;
        while(k-->0)
            ans += actualPrice.poll();
        return ans;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        souvenirs = sc.nextInt();
        budget    = sc.nextLong();
        initialPrice = new long[souvenirs + 1];

        for(int i = 1; i < souvenirs + 1; i++)
            initialPrice[i] = sc.nextInt();
        
        int lo = 1;
        int hi = souvenirs;
        while(lo <= hi)
        {
            int mid = (hi + lo) / 2;
            calculatePrice(mid);
            long cost = getCost(mid);

            if(cost <= budget)
            {
                lo = mid + 1;
                maxS = mid;
                minC = cost;
            }
            else
                hi = mid - 1;
        }
        System.out.println(maxS + " " + minC);
    }
}