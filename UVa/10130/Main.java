//10130

import java.awt.Point;
import java.util.*;

public class Main 
{
    static int[][] memo;
    static Point[] objects;

    public static int dp(int idx, int remW)
    {
        if(remW < 0)
            return (int) -1e9;

        if(idx == objects.length)
            return 0;
        
        if(memo[idx][remW] != -1)
            return memo[idx][remW];
        
        int take = objects[idx].x + dp(idx + 1, remW - objects[idx].y);
        int leave = dp(idx + 1, remW);
        
        return memo[idx][remW] = Math.max(take, leave);

    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            objects = new Point[n];
            for(int i = 0; i < n; i++)
                objects[i] = new Point(sc.nextInt(), sc.nextInt());
            
            memo = new int[n][31];
            for(int[] x : memo)
                Arrays.fill(x, -1);

            int sum = 0;
            int people = sc.nextInt();
            for(int i = 0; i < people; i++)
                sum += dp(0, sc.nextInt());

            if(t > 0) sb.append(sum + "\n");
            else sb.append(sum);
        }
        System.out.println(sb);
    }
}