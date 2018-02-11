//467C
//George and Job

import java.util.*;

public class GeorgeJob
{

    static int n, m, k;
    static long[] sum;
    static long[][] memo;

    public static long dp(int idx, int pairs)
    {
        if(idx == n || pairs == k) return 0;

        if(memo[idx][pairs] != -1)
            return memo[idx][pairs];

        int right = m + idx - 1;
        long max = Long.MIN_VALUE;
        if(right < n)
            max = Math.max(max, sum[right] - sum[idx - 1] + dp(right + 1, pairs + 1)); 
                   
        max = Math.max(max, dp(idx + 1, pairs));     

        return memo[idx][pairs] = max;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt() + 1;
        m = sc.nextInt();
        k = sc.nextInt();
        sum = new long[n];
        memo = new long[n][k];

        for(int i = 1; i < n; i++)
            sum[i] += sum[i - 1] + sc.nextInt();

        for(long[] xx : memo)
            Arrays.fill(xx, -1);

        System.out.println(dp(1, 0));
    }
}