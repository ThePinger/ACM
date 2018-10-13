//10404
//Bachet's Game

import java.io.*;
import java.util.*;

public class Main
{

    static int n, m;
    static int[] moves;
    static Boolean[] memo;

    public static boolean dp(int stones)
    {
        if(memo[stones] != null)
            return memo[stones];

        boolean result = false;
        for(int x : moves)
            if(x <= stones)
                result |= !dp(stones - x);

        return memo[stones] = result;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        while(sc.hasNext())
        {
            n = sc.nextInt();
            m = sc.nextInt();

            moves = new int[m];
            for(int i = 0; i < m; i++)
                moves[i] = sc.nextInt();

            memo = new Boolean[n + 1];
            for(int i = 4000; i < n; i += 4000) dp(i);
            pw.println(dp(n) ? "Stan wins" : "Ollie wins");
        }

        pw.flush();
        pw.close();
    }
}
