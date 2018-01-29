//339C
//Xenia and Weights

import java.util.*;

public class XeniaWeights
{
    static int n;
    static int[][][][] memo;
    static char[] available;
    static StringBuilder sb = new StringBuilder();

    public static int dp(int rem, int last, int diff, int direction)
    {
        if(rem == n)
        {
            if(diff != 0)
                return 1;
            return 0;
        }

        if(memo[rem][last][diff][direction] != -1)
            return memo[rem][last][diff][direction];


        int ways = 0;
        for(int i = 0; i < 10; i++)
            if(available[i] == '1' && (i + 1) - diff > 0 && i + 1 != last)
            {
                if(direction == 0)
                    ways += dp(rem + 1, i + 1, (i + 1) - diff, 1);
                else
                    ways += dp(rem + 1, i + 1, (i + 1) - diff, 0);
            }

        return memo[rem][last][diff][direction] = ways;
    }

    public static void print(int rem, int last, int diff, int direction)
    {
        if(rem == n)
            return;

        int left = 0;
        int right = 0;
        for(int i = 0; i < 10; i++)
            if(available[i] == '1' && (i + 1) - diff > 0 && i + 1 != last)
            {
                if(last == 0)
                {
                    left = dp(rem + 1, i + 1, (i + 1) - diff, 1);
                    if(left != 0)
                    {
                        sb.append(i + 1 + " ");
                        print(rem + 1, i + 1, (i + 1) - diff, 1);
                        return;
                    }
                }
                else
                {
                    right = dp(rem + 1, i + 1, (i + 1) - diff, 0);
                    if(right != 0)
                    {
                        sb.append(i + 1 + " ");
                        print(rem + 1, i + 1, (i + 1) - diff, 0);
                        return;
                    }
                }
            }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        available = sc.next().toCharArray();
        n = sc.nextInt();
        memo = new int[n][11][11][2];

        for(int[][][] x : memo)
            for(int[][] xx : x)
                for(int[] xxx : xx)
                    Arrays.fill(xxx, -1);

        int ans = dp(0, 0, 0, 0);

        if(ans == 0) System.out.println("NO");
        else
        {
            System.out.println("YES");
            print(0, 0, 0, 0);
            System.out.println(sb);
        }
    }
}