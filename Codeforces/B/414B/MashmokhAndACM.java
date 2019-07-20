//414B
//Mashmokh and ACM

import java.util.*;

public class MashmokhAndACM
{
    static int n, k;
    static int[][] memo;
    static int mod = 1000000007;

    public static int dp(int idx, int last)
    {
        if(idx == k) return 1;

        if(memo[idx][last] != -1)
            return memo[idx][last];

        long count = 0;
        if(last == 0)
        {
            for(int nxt = 1; nxt <= n; nxt++)
                count += dp(idx + 1, nxt);
        }
        else 
        {
            for(int nxt = last; nxt <= n; nxt += last)
                count += dp(idx + 1, nxt);
        }

        return memo[idx][last] = (int) (count % mod);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();

        memo = new int[k][n + 1];
        for(int[] x : memo)
            Arrays.fill(x, -1);

        System.out.println(dp(0, 0));
    }
}