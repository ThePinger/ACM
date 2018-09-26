//116
//Unidirectional TSP

import java.io.*;
import java.util.*;

public class Main
{

    static int row, col;
    static int[][] memo, grid;
    static PrintWriter pw = new PrintWriter(System.out);

    public static int dp(int x, int y)
    {
        if(y == col) return grid[x][y];

        if(memo[x][y] != -1) return memo[x][y];

        int min = Integer.MAX_VALUE;
        if(x == 0)
        {
            for(int i = 1; i <= row; i++)
                min = Math.min(min, dp(i, 1));
        }
        else
        {
            min = grid[x][y] + dp(x, y + 1);
            if(x + 1 <= row)
                min = Math.min(min, grid[x][y] + dp(x + 1, y + 1));
            else
                min = Math.min(min, grid[x][y] + dp(1, y + 1));

            if(x - 1 > 0)
                min = Math.min(min, grid[x][y] + dp(x - 1, y + 1));
            else
                min = Math.min(min, grid[x][y] + dp(row, y + 1));
        }

        return memo[x][y] = min;
    }

    public static void trace(int x, int y)
    {
        if(y == col)
        {
            pw.println(x);
            return;
        }
        
        if(x == 0)
        {
            for(int i = 1; i <= row; i++)
            {
                if(memo[x][y] == dp(i, 1))
                {
                    trace(i, 1);
                    break;
                }
            }
        }
        else
        {
            pw.print(x + " ");
            if(x + 1 > row && memo[x][y] == grid[x][y] + dp(1, y + 1))
                trace(1, y + 1);
            else if(x - 1 > 0 && memo[x][y] == grid[x][y] + dp(x - 1, y + 1))
                trace(x - 1, y + 1);
            else if(memo[x][y] == grid[x][y] + dp(x, y + 1))
                trace(x, y + 1);
            else if(x + 1 <= row && memo[x][y] == grid[x][y] + dp(x + 1, y + 1))
                trace(x + 1, y + 1);
            else
                trace(row, y + 1);
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext())
        {
            row = sc.nextInt();
            col = sc.nextInt();

            // if(row == 0) break;

            grid = new int[row + 1][col + 1];
            for(int i = 1; i <= row; i++)
                for(int j = 1; j <= col; j++)
                    grid[i][j] = sc.nextInt();

            memo = new int[row + 1][col + 1];
            for(int[] x : memo)
                Arrays.fill(x, -1);

            int min = dp(0, 0);
            trace(0, 0);
            pw.println(min);
        }

        pw.flush();
        pw.close();
    }
}