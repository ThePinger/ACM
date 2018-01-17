//10313
//Pay the price 
//DP
import java.util.*;
import java.io.*;

public class MainNew 
{
    static long[][][] memo;
    static int min, max, sum;

    public static long dp(int coinsUsed, int coin, int curSum)
    {
        if(coinsUsed < 0)
            return 0;

        if(curSum == 0)
        {
            if(coinsUsed == 0)
                return 1;
            return 0;
        }

        if(coin == 301)
            return 0;

        if(curSum < 0)
            return 0;
        
        if(memo[coinsUsed][coin][curSum] != -1)
            return memo[coinsUsed][coin][curSum];

        long ans = dp(coinsUsed - 1, coin, curSum - coin);
        ans += dp(coinsUsed, coin + 1, curSum);

        return memo[coinsUsed][coin][curSum] = ans;
    }

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringBuilder sb = new StringBuilder();
        int t = 1;

        memo = new long[301][301][301];
        for(long[][] x : memo)
            for(long[] xx : x)
                Arrays.fill(xx, -1);
        
        while(br.ready())
        {
            String[] s = br.readLine().split(" ");
            if(s.length == 1)
            {
                sum = Integer.parseInt(s[0]);
                min = 1;
                max = 300;
                if(sum == 0) sb.append(1);
                else
                {
                    long ans = 0;
                    for(int i = 1; i < sum + 1; i++)
                        ans += dp(i, 1, sum);
                    sb.append(ans);
                }
            }
            else if(s.length == 2)
            {
                sum = Integer.parseInt(s[0]);
                max = Integer.parseInt(s[1]);
                if(max > 300) max = 300;
                min = 1;
                if(sum == 0) sb.append(1);
                else
                {
                    long ans = 0;
                    for(int i = 1; i < max + 1; i++)
                        ans += dp(i, 1, sum);
                    sb.append(ans);
                }                 
            }
            else
            {
                sum = Integer.parseInt(s[0]);
                min = Integer.parseInt(s[1]);
                max = Integer.parseInt(s[2]);
                if(sum < min) sb.append(0);
                else
                {
                    if(max > 300) max = 300;
                    if(min > 300) min = 300;
                    if(sum == 0 && min == 0) sb.append(1);
                    else 
                    {
                        long ans = 0;
                        for(int i = min; i < max + 1; i++)
                            ans += dp(i, 1, sum);
                        sb.append(ans);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}