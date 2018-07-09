//10918
//Tri Tiling

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static int[][] memo;

    public static int dp(int rem, int empty)
    {
        if(rem < 0) return 0;

        if(rem == 0) 
        {
            if(empty == 0 || empty == 1 || empty == 2)
                return 1;
            return 0;
        }
        if(memo[rem][empty] != -1)
            return memo[rem][empty];

        int ways = 0;
        if(empty == 0)
        {
            ways += dp(rem - 2, 0);
            ways += dp(rem - 2, 1);
            ways += dp(rem - 2, 2);
        }
        else if(empty == 1)
        {
            ways += dp(rem, 0);
            ways += dp(rem - 1, 3);
        }
        else if(empty == 2)
        {
            ways += dp(rem, 0);
            ways += dp(rem - 1, 4);
        }
        else if(empty == 3)
            ways += dp(rem - 1, 1);
        else
            ways += dp(rem - 1, 2);;

        return memo[rem][empty] = ways;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            n = sc.nextInt();
            
            if(n == -1) break;

            memo = new int[n + 1][5];
            for(int[] x : memo)
                Arrays.fill(x, -1);

            pw.println(dp(n, 0));
        }

        pw.flush();
        pw.close();
    }
}