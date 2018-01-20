//10405
//Longest Common Subsequence
//DP
//Bottom Up

import java.io.*;

public class Main 
{
    static char[] stringOne, stringTwo;
    static int[][] dp;

    public static boolean valid(int i, int s)
    {
        if(s == 1)
            return i < stringOne.length;
        return i < stringTwo.length;
    }

    public static void fillMemo()
    {
        int oneL = stringOne.length - 1;
        int twoL = stringTwo.length - 1;
        if(stringOne[oneL] == stringTwo[twoL])
            dp[oneL][twoL] = 1;

        for(int idx1 = oneL; idx1 > -1; idx1--)
            for(int idx2 = twoL; idx2 > -1; idx2--)
                if(stringOne[idx1] == stringTwo[idx2])
                {
                    if(valid(idx1 + 1, 1) && valid(idx2 + 1, 2))
                        dp[idx1][idx2] = 1 + dp[idx1 + 1][idx2 + 1];                        
                    else
                        dp[idx1][idx2] = 1;                    
                }
                else
                {
                    if(valid(idx1 + 1, 1) && valid(idx2 + 1, 2))
                        dp[idx1][idx2] = Math.max(dp[idx1 + 1][idx2], dp[idx1][idx2 + 1]);                        
                    else if(valid(idx1 + 1, 1))
                        dp[idx1][idx2] = dp[idx1 + 1][idx2];
                    else if(valid(idx2 + 1, 2))
                        dp[idx1][idx2] = dp[idx1][idx2 + 1];  
                }                       
                    
    }

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter    pw = new PrintWriter(System.out);
        
        while(br.ready())
        {
            stringOne = br.readLine().toCharArray();
            stringTwo = br.readLine().toCharArray();
            dp = new int[stringOne.length][stringTwo.length];
            fillMemo();
            pw.println(dp[0][0]);
        }

        pw.flush();
        pw.close();
    }
}
