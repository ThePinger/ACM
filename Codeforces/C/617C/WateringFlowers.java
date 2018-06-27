//617C
//WateringFlowers

import java.util.*;

public class WateringFlowers
{

    public static long square(int x)
    {
        return 1l * x * x;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] rOne = new long[n + 1];    
        long[] rTwo = new long[n];
        
        Point centerOne = new Point(sc.nextInt(), sc.nextInt());
        Point centerTwo = new Point(sc.nextInt(), sc.nextInt());

        for(int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            rOne[i] = square(x - centerOne.x) + square(y - centerOne.y);
            rTwo[i] = square(x - centerTwo.x) + square(y - centerTwo.y);
        }

        long ans = Long.MAX_VALUE;
        for(int i = 0; i < n + 1; i++)
        {
            long maxR2 = 0;
            for(int j = 0; j < n; j++)
                if(rOne[j] > rOne[i])
                    maxR2 = Math.max(maxR2, rTwo[j]);
            ans = Math.min(ans, maxR2 + rOne[i]);
        }

        System.out.println(ans);
    }

    static class Point
    {
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}