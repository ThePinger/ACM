//11974
//Switch The Lights

import java.io.*;
import java.util.*;

public class Main
{

    static int n, m;
    static int[][] memo;
    static boolean[][] opens;
    static final int INF = (int) 1e9;

    public static int dp(int idx, int mask)
    {
        if(idx == m)
        {
            if(Integer.bitCount(mask) == n)
                return 0;
            return INF;
        }

        if(memo[idx][mask] != -1)
            return memo[idx][mask];

        int tmpMask = mask;
        for(int j = 0; j < n; j++)
            if(opens[idx][j])
                tmpMask ^= 1 << j;

        int take = 1 + dp(idx + 1, tmpMask);
        int leave = dp(idx + 1, mask);

        return memo[idx][mask] = Math.min(take, leave);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();    

        for(int c = 1; c <= t; c++)
        {
            n = sc.nextInt();
            m = sc.nextInt();
            opens = new boolean[m][n];
            for(int i = 0; i < m; i++)
                for(int j = 0; j < n; j++)
                    if(sc.nextInt() == 1)
                        opens[i][j] = true;

            memo = new int[m][1 << n];
            for(int[] x : memo)
                Arrays.fill(x, -1);

            int ans = dp(0, 0);
            if(ans >= INF)
                pw.println("Case " + c + ": IMPOSSIBLE");
            else
                pw.println("Case " + c + ": " + ans);
        }

        pw.flush();
        pw.close();
    }
}