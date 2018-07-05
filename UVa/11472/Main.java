//11472
//Beautiful Numbers

import java.io.*;
import java.util.*;

public class Main
{

    static int n, m;
    static long[][][] memo;

    public static long dp(int idx, int mask, int pre)
    {
        if(idx == m)
        {
            if(Integer.bitCount(mask) == n)
                return 1;
            return 0;
        }

        if(memo[idx][mask][pre] != -1)
            return memo[idx][mask][pre];

        long ways = 0;
        if(idx == 0)
        {
            for(int i = 1; i < n; i++)
                ways += dp(idx + 1, mask | 1 << i, i);
        }
        else
        {
            if(pre == 0)
                ways += dp(idx + 1, mask | 1 << pre + 1, pre + 1);
            else if(pre == n - 1)
                ways += dp(idx + 1, mask | 1 << pre - 1, pre - 1);
            else
                ways += dp(idx + 1, mask | 1 << pre - 1, pre - 1) + dp(idx + 1, mask | 1 << pre + 1, pre + 1);
            
            if(Integer.bitCount(mask) == n) ways++;
        }

        return memo[idx][mask][pre] = ways % 1000000007;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            n = sc.nextInt();
            m = sc.nextInt();
            memo = new long[m][1 << n][n];
            for(long[][] x : memo)
                for(long[] xx : x)
                    Arrays.fill(xx, -1);
            pw.println(dp(0, 0, 0));
        }

        pw.flush();
        pw.close();
    }
}