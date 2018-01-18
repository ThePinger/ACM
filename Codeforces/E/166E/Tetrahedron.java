//166E
//Tetrahedron

import java.util.*;

public class Tetrahedron
{
    static int[][] memo;
    static int mod = 1000000007;

    public static int dp(int cur, int remSteps)
    {
        if(remSteps == 0)
        {
            if(cur == 0)
                return 1;
            return 0;
        }

        if(memo[cur][remSteps] != -1)
            return memo[cur][remSteps];

        long ways = 0;
        if(cur == 1)
            ways = dp(0, remSteps - 1) + (2l * dp(1, remSteps - 1)) ;
        else
            ways = (3l * dp(1, remSteps - 1));

        return memo[cur][remSteps] = (int) (ways % mod);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[2][10000001];
        for(int[] x : memo)
            Arrays.fill(x, -1);

        int ways = 0;
        for(int i = 5000; i <= 10000000; i += 5000)
            dp(0, i);

        System.out.println(dp(0, n));
    }
}