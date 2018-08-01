//1015E2
//Stars Drawing (Hard Edition)

import java.io.*;
import java.util.*;

public class StarsDrawing
{

    static int n, m;
    static char[][] grid;

    public static boolean isValid(int i, int j)
    {
        return i > -1 && j > -1 && i < n && j < m && grid[i][j] == '*';
    }

    public static int move(int i, int j, int x, int y)
    {
        return !isValid(i + x, j + y) ? 0 : 1 + move(i + x, j + y, x, y);
    }

    public static void mark(int i, int j, int x, int y, int dist)
    {
        grid[i][j] = '#';
        if(dist == 0) return;
        mark(i + x, j + y, x, y, dist - 1);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][m];

        for(int i = 0; i < n; i++)
            grid[i] = sc.next().toCharArray();


        int[][] up = new int[n][m];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(isValid(j, i))
                    up[j][i] += isValid(j, i - 1) ? 1 + up[j][i - 1] : 0;

        int[][] down = new int[n][m];
        for(int i = m - 1; i > -1; i--)
            for(int j = 0; j < n; j++)
                if(isValid(j, i))
                    down[j][i] += isValid(j, i + 1) ? 1 + down[j][i + 1] : 0;

        int[][] right = new int[n][m];
        for(int i = n - 1; i > -1; i--)
            for(int j = 0; j < m; j++)
                if(isValid(i, j))
                    right[i][j] += isValid(i + 1, j) ? 1 + right[i + 1][j] : 0;

        int[][] left = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(isValid(i, j))
                    left[i][j] += isValid(i - 1, j) ? 1 + left[i - 1][j] : 0;

        int count = 0;
        boolean starFound = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] != '.')
                {
                    starFound = true;
                    int min = Math.min(Math.min(up[i][j], down[i][j]), Math.min(right[i][j], left[i][j]));
                    if(min > 0)
                    {
                        count++;
                        for(int c = 0; c <= min; c++)
                        {
                            grid[i + c][j] = '#';
                            grid[i - c][j] = '#';
                            grid[i][j + c] = '#';
                            grid[i][j - c] = '#';
                        }
                        sb.append((i + 1) + " " + (j + 1) + " " + min + "\n");
                    }
                }
            }
        }

        boolean flag = true;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(grid[i][j] == '*')
                    flag = false;

        if((count == 0 && starFound) || !flag) pw.println(-1);
        else
        {
            pw.println(count);
            pw.print(sb);
        }

        pw.flush();
        pw.close();
    }

    static class Triple
    {
        int x, y, dist;

        public Triple(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}