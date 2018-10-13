//12469
//Stones

import java.io.*;
import java.util.*;

public class Main
{

    static Boolean[][] memo;

    public static boolean dp(int stones, int max)
    {
        if(memo[stones][max] != null)
            return memo[stones][max];

        boolean result = false;
        for(int i = 1; i <= max; i++)
            result |= !dp(stones - i, Math.min(stones - i, i * 2));

        return memo[stones][max] = result;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        memo = new Boolean[1001][1000];
        while(true)
        {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            pw.println(dp(n, n - 1) ? "Alicia" : "Roberto");
        }

        pw.flush();
        pw.close();
    }
}