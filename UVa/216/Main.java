//216
//Getting in Line
//DP
//100th

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.Point;

public class Main 
{
    static int computers;
    static double[][] memo;
    static Point[] points;
    static PrintWriter pw = new PrintWriter(System.out);
    static DecimalFormat df = new DecimalFormat("#0.00");

    public static boolean allVis(int mask)
    {
        return Integer.bitCount(mask) == computers;
    }

    public static boolean visited(int idx, int mask)
    {
        return ((1 << idx) & mask) == (1 << idx);
    }

    public static double dp(int i, int mask)
    {
        if(allVis(mask))
            return 0;

        if(memo[i][mask] != -1)
            return memo[i][mask];

        
        double take = 1e9;
        for(int j = 0; j < computers; j++)
            if(i != j && !visited(j, mask))
            {
                double distance = 16 + Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                take = Math.min(take, distance + dp(j, mask | 1 << j));
            }

        return memo[i][mask] = take;
    }

    public static void print(int i, int mask)
    {
        if(allVis(mask))
            return;

        double take = 1e9;
        for(int j = 0; j < computers; j++)
            if(i != j && !visited(j, mask))
            {
                double distance = 16 + Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                double tmp = distance + dp(j, mask | 1 << j);
                if(memo[i][mask] == tmp)
                {
                    String d = df.format(Math.round(distance * 100) / 100.0);
                    pw.println("Cable requirement to connect (" + points[i].x + "," + points[i].y + ") to (" + points[j].x + "," + points[j].y + ") is " + d + " feet." );
                    print(j, mask | 1 << j);
                    break;
                }
            }
    }

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;

        while(true)
        {
            computers = Integer.parseInt(br.readLine());
            if(computers == 0) break;

            pw.println("**********************************************************");
            pw.println("Network #" + (t++));
            points = new Point[computers];
            
            for(int i = 0; i < computers; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            memo = new double[computers][1 << computers];
            for(double[] xx : memo)
                Arrays.fill(xx, -1);

            double min = 1e9;
            for(int i = 0; i < computers; i++)
                min = Math.min(min, dp(i, 1 << i));

            for(int i = 0; i < computers; i++)
                if(min == dp(i, 1 << i))
                {
                    print(i, 1 << i);
                    break;
                }
            
            String m = df.format(Math.round(min * 100) / 100.0);
            pw.println("Number of feet of cable required is " + m + ".");
        }
        pw.flush();
        pw.close();
    }
}