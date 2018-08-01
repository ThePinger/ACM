//1015E1
//Stars Drawing (Easy Edition)

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

        int count = 0;
        boolean starFound = false;
        StringBuilder sb = new StringBuilder();
        Queue<Triple> queue = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '*')
                {
                    starFound = true;
                    int top = move(i, j, -1, 0);
                    int bottom = move(i, j, 1, 0);
                    int right = move(i, j, 0, 1);
                    int left = move(i, j, 0, -1);

                    int min = Math.min(Math.min(top, bottom), Math.min(right, left));
                    if(min > 0)
                    {
                        count++;
                        queue.add(new Triple(i, j, min));
                        sb.append((i + 1) + " " + (j + 1) + " " + min + "\n");
                    }
                }
            }
        }

        while(!queue.isEmpty())
        {
            Triple p = queue.poll();
            mark(p.x, p.y, -1, 0, p.dist);
            mark(p.x, p.y, 1, 0, p.dist);
            mark(p.x, p.y, 0, 1, p.dist);
            mark(p.x, p.y, 0, -1, p.dist);
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