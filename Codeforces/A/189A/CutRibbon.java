//189A
//Cut Ribbon

import java.util.*;
import java.io.*;

public class CutRibbon
{
    static int[][] memo;
    static int[] ribbons;
    static int n;
    public static int dp(int rib, int sum)
    {
        if(sum > n)
            return (int) -1e9;
        if(rib == 3)
            if(sum == n)
                return 0;
            else
                return (int) -1e9;
        
        if(memo[rib][sum] != -1)
            return memo[rib][sum];
        
        int take = 1 + dp(rib, sum + ribbons[rib]);
        int leave =  dp(rib + 1, sum);

        return memo[rib][sum] = Math.max(take, leave);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        ribbons = new int[3];
        memo = new int[3][5000];
        ribbons[0] = a;
        ribbons[1] = b;
        ribbons[2] = c;
        for(int[] x : memo)
            Arrays.fill(x, -1);

        System.out.println(dp(0, 0));
    }
}