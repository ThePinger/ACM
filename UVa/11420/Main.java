//11420
//Chest of Drawers
//DP

import java.util.*;

public class Main
{

    static int drawers, secured;
    static long[][][] memo;

    public static long dp(int drawersDone, int secu, int last)
    {
        if(drawersDone == drawers)
        {
            if(secu == secured)
                return 1;
            return 0;
        }

        if(secu > secured)
            return 0;
        
        if(memo[drawersDone][secu][last] != -1)
            return memo[drawersDone][secu][last];

        long ans = 0;
        if(last == 0)
        {
            ans += dp(drawersDone + 1, secu, 1);
            ans += dp(drawersDone + 1, secu, 0);
        }
        else
        {
            ans += dp(drawersDone + 1, secu + 1, 1);
            ans += dp(drawersDone + 1, secu, 0);
        }

        return memo[drawersDone][secu][last] = ans;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while(true)
        {
            drawers = sc.nextInt();
            secured = sc.nextInt();
            if(drawers < 0) break;
            else if(t > 1) sb.append("\n");

            memo = new long[drawers][secured + 1][2];
            for(long[][] xx : memo)
                for(long[] x : xx)
                    Arrays.fill(x, -1);

            sb.append(dp(0, 0, 1));
            t++;
        }

        System.out.println(sb);
    }
}