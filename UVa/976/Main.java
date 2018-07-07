//976
//Bridge Building

import java.io.*;
import java.util.*;

public class Main
{
    static int row, col;
    static char direction;
    static char[][] grid;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static boolean valid(int i, int j)
    {
        return i > -1 && j > -1 && i < row && j < col && grid[i][j] != '.' && grid[i][j] != direction;
    }

    public static void floodfill(int i, int j)
    {
        grid[i][j] = direction;
        for(int c = 0; c < 4; c++)
            if(valid(i + dx[c], j + dy[c]))
                floodfill(i + dx[c], j + dy[c]);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.hasNext())
        {
            row = sc.nextInt();
            col = sc.nextInt();
            // if(row == 0) break; 
            int bridges = sc.nextInt();
            int dist = sc.nextInt();
            int[] distance = new int[col];
            grid = new char[row][col];
            for(int i = 0; i < row; i++)
                grid[i] = sc.next().toCharArray();

            direction = 'N';
            floodfill(0, 0);
            direction = 'S';
            floodfill(row - 1, col - 1);

            for(int i = 0; i < col; i++)
                for(int j = 0; j < row; j++)
                    if(grid[j][i] == 'S')
                        break;
                    else if(grid[j][i] == 'N' && distance[i] > 0)
                        distance[i] = 0;
                    else if(grid[j][i] == '.')
                        distance[i]++;

            int[][] dp = new int[col + 1][bridges + 1];
            Arrays.fill(dp[col], (int) 1e9);
            dp[col][bridges] = 0;
            for(int idx = col - 1; idx > -1; idx--)
                for(int bridge = 0; bridge < bridges; bridge++)
                    if(idx + dist + 1 < col)
                        dp[idx][bridge] = Math.min(distance[idx] + dp[idx + dist + 1][bridge + 1], dp[idx + 1][bridge]);
                    else
                        dp[idx][bridge] = Math.min(distance[idx] + dp[col][bridge + 1], dp[idx + 1][bridge]);
            
            pw.println(dp[0][0]);
        }

        pw.flush();
        pw.close();
    }   
}