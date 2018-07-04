//10874
//Segments

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static int[][] memo;
    static Pair[] ranges;

    public static int dp(int idx, int last)
    {
        int cur = last == 0 ? ranges[idx - 1].x : ranges[idx - 1].y;
        if(idx == n) 
            return cur == n - 1 ? -1 : Math.abs(cur - (n - 1)) - 1; 

        if(memo[idx][last] != -1)
            return memo[idx][last];

        Pair range = ranges[idx];

        int right = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
        if(range.y <= cur)
            left = cur - range.x + 1 + dp(idx + 1, 0);
        else if(range.x < cur && range.y > cur)
        {
            right = cur - range.x + range.y - range.x + 1 + dp(idx + 1, 1);
            left  = range.y - cur + range.y - range.x + 1 + dp(idx + 1, 0);
        }
        else
            right = range.y - cur + 1 + dp(idx + 1, 1);

        return memo[idx][last] = Math.min(right, left);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            n = sc.nextInt() + 1;

            if(n == 1) break;
            
            memo = new int[n][2];
            ranges = new Pair[n];

            ranges[0] = new Pair(1, 1);
            for(int i = 1; i < ranges.length; i++)
                ranges[i] = new Pair(sc.nextInt(), sc.nextInt());

            for(int[] x : memo)
                Arrays.fill(x, -1);

            pw.println(dp(1, 0));
        }

        pw.flush();
        pw.close();
    }

    static class Pair
    {
        int x, y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}