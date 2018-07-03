//926
//Walking Around Wisely

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static long[][] memo;
    static Point start, end;
    static boolean[][] blockedEast;
    static boolean[][] blockedNorth;

    public static long dp(int x, int y)
    {
        if(x == end.x && y == end.y) return 1;

        if(memo[x][y] != -1)
            return memo[x][y];

        long ways = 0;
        if(x != n && !blockedEast[x + 1][y])
            ways += dp(x + 1, y);
        if(y != n && !blockedNorth[x][y + 1])
            ways += dp(x, y + 1);

        return memo[x][y] = ways;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            n = sc.nextInt();
            blockedEast = new boolean[n + 1][n + 1];
            blockedNorth = new boolean[n + 1][n + 1];
            start = new Point(sc.nextInt(), sc.nextInt());
            end = new Point(sc.nextInt(), sc.nextInt());

            int blocked = sc.nextInt();
            while(blocked-->0)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                char direction = sc.next().charAt(0);
                if(direction == 'S')
                    blockedNorth[a][b] = true;
                else if(direction == 'W')
                    blockedEast[a][b] = true;
                else if(direction == 'N')
                    blockedNorth[a][b + 1] = true;
                else
                    blockedEast[a + 1][b] = true;
            }

            memo = new long[n + 1][n + 1];
            for(long[] x : memo)
                Arrays.fill(x, -1);

            pw.println(dp(start.x, start.y));
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