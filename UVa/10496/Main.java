//10496
//Collecting Beepers

import java.io.*;
import java.util.*;

public class Main
{

    static int n, startX, startY;
    static int[][][] memo;
    static ArrayList<Pair> coor;

    public static boolean isTaken(int msk, int i)
    {
        return ((1 << i) & msk) == (1 << i);
    }

    public static int dp(int x, int y, int msk)
    {
        if(Integer.bitCount(msk) == n)
            return Math.abs(x - startX) + Math.abs(y - startY);

        if(memo[x][y][msk] != -1) 
            return memo[x][y][msk];

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            if(!isTaken(msk, i))
                min = Math.min(min, Math.abs(x - coor.get(i).x) + Math.abs(y - coor.get(i).y) + dp(coor.get(i).x, coor.get(i).y, msk | (1 << i)));

        return memo[x][y][msk] = min;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0)
        {
            int x = sc.nextInt(); 
            int y = sc.nextInt();
            startX = sc.nextInt();
            startY = sc.nextInt();
            n = sc.nextInt();

            coor = new ArrayList<>();
            for(int i = 0; i < n; i++)
                coor.add(new Pair(sc.nextInt(), sc.nextInt()));

            memo = new int[x + 1][y + 1][1 << 11];
            for(int[][] xxx : memo)
                for(int[] xx : xxx)
                    Arrays.fill(xx, -1);

            pw.println("The shortest path has length " + dp(startX, startY, 0));
        }

        pw.flush();
        pw.close();
    }

    static class Pair
    {
        int x, y;

        public Pair(int x, int y)
        {
            this.x = x;
            this. y = y;
        }
    }
}