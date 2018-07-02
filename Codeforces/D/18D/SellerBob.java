//18D
//SellerBob

import java.math.BigInteger;
import java.util.*;

public class SellerBob
{

    static int n;
    static Pair[] arr;
    static BigInteger[][] memo;

    public static BigInteger dp(int idx, int stock)
    {
        if(idx == n) return BigInteger.ZERO;

        if(memo[idx][stock + 1] != null)
            return memo[idx][stock + 1];

        BigInteger take = BigInteger.ZERO, leave = BigInteger.ZERO;
        if(arr[idx].type == 'S')
        {
            if(arr[idx].val == stock)
                take = new BigInteger("2").pow(arr[idx].val).add(dp(idx + 1, -1));
            else
                leave = dp(idx + 1, stock);
        }
        else
        {
            take = dp(idx + 1, arr[idx].val);
            leave = dp(idx + 1, stock);
        }

        return memo[idx][stock + 1] = take.max(leave);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);  

        n = sc.nextInt();
        arr = new Pair[n];
        for(int i = 0; i < n; i++)
        {
            String tmp = sc.next();
            if(tmp.equals("win"))
                arr[i] = new Pair(sc.nextInt(), 'W');
            else
                arr[i] = new Pair(sc.nextInt(), 'S');
        }  

        memo = new BigInteger[n][2002];
        System.out.println(dp(0, -1));
    }

    static class Pair
    {
        int val;
        char type;

        public Pair(int val, char type)
        {
            this.val = val;
            this.type = type;
        }
    }
}