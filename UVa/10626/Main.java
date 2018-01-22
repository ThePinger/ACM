//10626
//Buying Coke
//DP
//Top Down

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main 
{
    static int sum, ones, five, tens, coke;
    static int[][][] dp;
    static int max = (int) 1e9;

    public static int minCoins(int cokes, int fiv, int ten)
    {
        if(fiv < 0 || ten < 0 || fiv > five + Math.min(ones/3, tens)) return max;
        if(cokes == coke) return 0;

        if(dp[cokes][fiv][ten] != -1)
            return dp[cokes][fiv][ten];

        int remS = sum - (cokes * 8) - (fiv * 5) - (ten * 10);
        
        int takeT = 1 + minCoins(cokes + 1, fiv, ten - 1);
        int take2F = 2 + minCoins(cokes + 1, fiv - 2, ten);
        int takeFOne = max;
        int takeTOne = max;
        int takeOne  = max;

        if(remS > 2)
        {
            takeFOne = 4 + minCoins(cokes + 1, fiv - 1, ten);
            takeTOne = 4 + minCoins(cokes + 1, fiv + 1, ten - 1);
            if(remS > 7) takeOne = 8 + minCoins(cokes + 1, fiv, ten);
        }

        return dp[cokes][fiv][ten] = Math.min(Math.min(takeT, takeFOne), Math.min(Math.min(takeTOne, takeOne), take2F));
    }

    /*public static void fill()
    {
        for(int fiv = 0; fiv < five+ Math.min(ones/3, tens) + 1; fiv++)
            for(int ten = 0; ten < tens + 1; ten++)
            {
                int remS = sum - (fiv * 5) - (ten * 10);                
                
                if(ten > 0)
                    dp[coke][fiv][ten] = 1;
                else if(fiv > 1)
                    dp[coke][fiv][ten] = 2;
                else if(remS > 2 && fiv > 0)
                    dp[coke][fiv][ten] = 4;
                else if(remS > 7)
                    dp[coke][fiv][ten] = 8;  
            }

        for(int cok = coke - 1; cok > -1; cok--)
            for(int fiv = 0; fiv < five + Math.min(ones/3, tens) + 1; fiv++)
                for(int ten = 0; ten < tens + 1; ten++)
                {
                    int remS = sum - (8 * (coke - cok)) - (fiv * 5) - (ten * 10);
                    int takeT    = max;
                    int takeFOne = max;
                    int takeTOne = max;
                    int takeOne  = max;
                    int take2F   = max;

                    if(ten > 0) takeT = 1 + dp[cok + 1][fiv][ten - 1];
                    if(fiv > 0 && remS > 2) takeFOne = 4 + dp[cok + 1][fiv - 1][ten];
                    if(ten > 0 && remS > 2) takeTOne = 4 + dp[cok + 1][fiv + 1][ten - 1];
                    if(remS > 7) takeOne = 8 + dp[cok + 1][fiv][ten];
                    if(fiv > 1) take2F = 2 + dp[cok + 1][fiv - 2][ten];

                    if(takeT == max && takeFOne == max && takeTOne == max && takeOne == max && take2F == max)
                        continue;

                    dp[cok][fiv][ten] = Math.min(Math.min(takeT, takeFOne), Math.min(Math.min(takeTOne, takeOne), take2F));             
                }                 
    }*/

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        PrintWriter    pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());        

        while(t-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coke = Integer.parseInt(st.nextToken());
            ones = Integer.parseInt(st.nextToken());
            five = Integer.parseInt(st.nextToken());
            tens = Integer.parseInt(st.nextToken());
            sum = ones + (five * 5) + (tens * 10); 
            dp  = new int[coke + 1][five + Math.min(ones/3, tens) + 1][tens + 1];
            
            for(int[][] cc : dp)
                for(int[] ccc : cc)
                    Arrays.fill(ccc, -1);
            //fill();
            pw.println(minCoins(0, five, tens));
        }

        pw.flush();
        pw.close();
    }
}