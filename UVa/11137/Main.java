//11137
//Ingenuous Cubrency
//DP
//Bottom Up

import java.util.*;

public class Main 
{
    static int[] coins;
    static long[][] memo;

    public static void dp()
    {
        for(int i = 0; i < 10001; i++)
            memo[21][i] = i % coins[21] == 0 ? 1 : 0;

        for(int i = 20; i > -1; i--)
            for(int sumR = 0; sumR < 10001; sumR++)
                if(sumR - coins[i] > -1)
                    memo[i][sumR] = memo[i][sumR - coins[i]] + memo[i + 1][sumR];
                else
                    memo[i][sumR] = memo[i + 1][sumR];
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        coins = new int[22];
        for(int i = 1; i < 22; i++)
            coins[i] = i * i * i;

        memo = new long[22][10001];
        dp();
        memo[0][0] = 0;
        int t = 1;

        while(sc.hasNext())
        {
            if(t > 1) sb.append("\n");
            int n = sc.nextInt();
            sb.append(memo[0][n]);
            t++;
        }

        System.out.println(sb);
    }
}