//990
//Diving for Gold

import java.util.*;
import java.io.PrintWriter;
import java.awt.Point;

public class Main 
{
    static StringBuilder sb;
    static Point[] treasures;
    static int[][] memo;
    static int bottleAir, w, treasure, c;


    public static void print(int idx, int airRem)
    {
        if(idx == treasure)
            return;

        int take = 0;
        int leave = 0;
        int dtime = w * treasures[idx].x;
        int atime = 2 * w * treasures[idx].x;
        if(dtime + atime <= airRem)
        {
            take = treasures[idx].y + dp(idx + 1, airRem - dtime - atime);
            leave = dp(idx + 1, airRem);
            if(memo[idx][airRem] == leave)
                print(idx + 1, airRem);
            else
            {
                sb.append(treasures[idx].x + " " + treasures[idx].y + "\n");
                c++;
                print(idx + 1, airRem - dtime - atime);
            }
        }
        else
            print(idx + 1, airRem);       
    }

    public static int dp(int idx, int airRem)
    {
        if(idx == treasure)
            return 0;

        if(memo[idx][airRem] != -1)
            return memo[idx][airRem];
        
        int dtime = w * treasures[idx].x;
        int atime = 2 * w * treasures[idx].x;

        int take = 0;
        if(dtime + atime <= airRem)
            take = treasures[idx].y + dp(idx + 1, airRem - dtime - atime);
        int leave = dp(idx + 1, airRem);
        
        return memo[idx][airRem] = Math.max(take, leave);
    }
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        
        while(sc.hasNext())
        {
            sb = new StringBuilder();
            c = 0;

            bottleAir = sc.nextInt();
            w = sc.nextInt();
            treasure = sc.nextInt();
            treasures = new Point[treasure];
            for(int i = 0; i < treasure; i++)
                treasures[i] = new Point(sc.nextInt(), sc.nextInt());

            memo = new int[treasure][bottleAir + 1];
            for(int[] x : memo)
                Arrays.fill(x, -1);

            int max = dp(0, bottleAir);
            print(0, bottleAir);

            if(t > 1) pw.println();
            pw.println(max);
            pw.println(c);
            pw.print(sb);
            t++;
        }
        pw.flush();
        pw.close();
    }
}
