//10944
//Nuts for nuts

import java.io.*;
import java.util.*;

public class Main
{

    static int n, m, nuts;
    static Point start;
    static int[][] memo;
    static ArrayList<Point> pos;

    public static boolean visited(int idx, int mask)
    {
        return ((1 << idx) & mask) == 1 << idx;
    }

    public static int dist(int i, int j)
    {
        return Math.max(Math.abs(pos.get(i).x - pos.get(j).x), Math.abs(pos.get(i).y - pos.get(j).y));        
    }

    public static int dp(int cur, int mask)
    {
        if(Integer.bitCount(mask) == nuts)
            return dist(cur, pos.size() - 1);

        if(memo[cur][mask] != -1)
            return memo[cur][mask];

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nuts; i++)
            if(!visited(i, mask))
                ans = Math.min(ans, dist(cur, i) + dp(i, mask | (1 << i)));

        return memo[cur][mask] = ans;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.hasNext())
        {
            n = sc.nextInt();
            m = sc.nextInt();
            
            start = new Point(0, 0);
            pos = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                char[] tmp = sc.next().toCharArray();
                for(int j = 0; j < m; j++)
                    if(tmp[j] == 'L')
                        start = new Point(i, j);
                    else if(tmp[j] == '#')
                        pos.add(new Point(i, j));
            }

            nuts = pos.size();
            pos.add(start);
            memo = new int[pos.size()][1 << pos.size()];
            for(int[] x : memo)
                Arrays.fill(x, -1);

            pw.println(dp(pos.size() - 1, 0));
        }

        pw.flush();
        pw.close();
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