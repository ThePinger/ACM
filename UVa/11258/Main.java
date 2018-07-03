//11258
//String Partition

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static char[] nums;
    static long[][] memo;

    public static int toInt(int start, int end)
    {
        String s = "";
        while(start <= end)
            s += nums[start++];
        return Integer.parseInt(s);
    }

    public static boolean isInt(int start, int end)
    {
        String s = "";
        while(start <= end)
            s += nums[start++];
        return Long.parseLong(s) <= Integer.MAX_VALUE;
    }

    public static long dp(int idx, int start)
    {
        if(idx == n)
            return start < n ? toInt(start, n - 1) : 0;

        if(memo[idx][start] != -1)
            return memo[idx][start];

        long take = Long.MIN_VALUE, leave = Long.MIN_VALUE;
        if(idx + 1 < n && isInt(start, idx + 1))
            take = dp(idx + 1, start);
        leave = toInt(start, idx) + dp(idx + 1, idx + 1);

        return memo[idx][start] = Math.max(take, leave);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            nums = sc.next().toCharArray();
            n = nums.length;

            memo = new long[n][n];
            for(long[] x : memo)
                Arrays.fill(x, -1);

            pw.println(dp(0, 0));
        }

        pw.flush();
        pw.close();
    }
}