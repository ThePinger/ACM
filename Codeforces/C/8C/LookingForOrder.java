//8C
//LookingForOrder

import java.io.PrintWriter;
import java.util.*;

public class LookingForOrder
{

    static int n;
    static int[] memo;
    static Pair start;
    static Pair[] coordinates;
    static PrintWriter pw = new PrintWriter(System.out);

    public static boolean isVisited(int msk, int x)
    {
        return ((1 << x) & msk) == (1 << x); 
    }

    public static int dist(Pair fir, Pair sec)
    {
        int x = fir.x - sec.x;
        int y = fir.y - sec.y;
        return (x * x) + (y * y);
    }

    public static int dp(int msk)
    {
        if(n == Integer.bitCount(msk))
            return 0;

        if(memo[msk] != -1) return memo[msk];

        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i = 0; i < n && !flag; i++)
        {
            for(int j = 0; j < n && !isVisited(msk, i); j++)
            {
                if(i != j && !isVisited(msk, j))
                {
                    min = Math.min(min, dist(start, coordinates[i]) + dist(coordinates[i], coordinates[j]) + dist(coordinates[j], start) + dp(msk | 1 << i | 1 << j));
                    flag = true;
                }
                else if(i == j)
                {
                    min = Math.min(min, dist(start, coordinates[i]) + dist(coordinates[i], start) + dp(msk | 1 << i));
                    flag = true;
                }
            }
        }
        
        return memo[msk] = min;
    }

    public static void trace(int msk)
    {
        if(n == Integer.bitCount(msk))
        {
            pw.println("0");
            return;
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n && !isVisited(msk, i); j++)
            {
                if(i != j && !isVisited(msk, j) && dist(start, coordinates[i]) + dist(coordinates[i], coordinates[j]) + dist(coordinates[j], start) + dp(msk | 1 << i | 1 << j) == memo[msk])
                {
                    pw.print(0 + " " + (i + 1) + " " + (j + 1) + " ");
                    trace(msk | 1 << i | 1 << j);
                    return;
                }    
                else if(i == j && dist(start, coordinates[i]) + dist(coordinates[i], start) + dp(msk | 1 << i) == memo[msk])
                {
                    pw.print(0 + " " + (i + 1) + " ");
                    trace(msk | 1 << i);
                    return;
                }            
            }   
        } 
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);  
        
        start = new Pair(sc.nextInt(), sc.nextInt());

        n = sc.nextInt();
        coordinates = new Pair[n];
        for(int i = 0; i < n; i++)
            coordinates[i] = new Pair(sc.nextInt(), sc.nextInt());

        memo = new int[1 << n];
        Arrays.fill(memo, -1);

        pw.println(dp(0));
        trace(0);
        pw.flush();
        pw.close();
    }

    static class Pair
    {
        int x, y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}