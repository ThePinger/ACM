//10130
//SuperSale
//DP
//BottomUp

import java.util.*;
import java.awt.Point;

public class MainBottomUp
{
    static int[][] memo;
    static Point[] objects;

    public static void dp()
    {
        int n = objects.length - 1;
        for(int i = 0; i < 31; i++)
            memo[n][i] = objects[n].y <= i ? objects[n].x : 0;

        for(int idx = n - 1; idx > -1; idx--)
            for(int remW = 0; remW < 31; remW++)
                if(objects[idx].y <= remW)
                    memo[idx][remW] = Math.max(objects[idx].x + memo[idx + 1][remW - objects[idx].y], memo[idx + 1][remW]);
                else
                    memo[idx][remW] = memo[idx + 1][remW];
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
            int sum = 0;
            int people = sc.nextInt();
            dp();
            for(int i = 0; i < people; i++)
                sum += memo[0][sc.nextInt()];

            if(t > 0) sb.append(sum + "\n");
            else sb.append(sum);
        }
        System.out.println(sb);
    }
}