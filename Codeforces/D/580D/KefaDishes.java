//580D
//Kefa and Dishes
//DP

import java.util.*;

public class KefaDishes
{
    static long[][] memo, extra;
    static int[] satisf;
    static int dishes;

    public static boolean allVis(int mask)
    {
        return Integer.bitCount(mask) == dishes;
    }

    public static boolean visited(int idx, int mask)
    {
        return ((1 << idx) & mask) == (1 << idx);
    }

    public static long dp(int idx, int mask)
    {
        if(allVis(mask))
            return 0;

        if(memo[idx][mask] != -1)
            return memo[idx][mask];

        long take = 0;
        for(int j = 0; j < satisf.length; j++)
            if(idx != j && !visited(j, mask))
                take = Math.max(take, extra[idx][j] + satisf[j] +  dp(j, mask | 1 << j));
        
        return memo[idx][mask] = take;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);  
        satisf = new int[sc.nextInt()];
        dishes = sc.nextInt();
        int rules = sc.nextInt();

        for(int i = 0; i < satisf.length; i++)
            satisf[i] = sc.nextInt();

        extra = new long[19][19];
        for(int i = 0; i < rules; i++)
            extra[sc.nextInt() - 1][sc.nextInt() - 1] = sc.nextInt();

        memo = new long[satisf.length][1 << satisf.length];
        for(long[] x : memo)
            Arrays.fill(x, -1);

        long max = 0;
        for(int i = 0; i < satisf.length; i++)
            max = Math.max(max, satisf[i] + dp(i, 1 << i));
        
        System.out.println(max);
    }
}