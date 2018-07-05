//116B
//LittlePigsAndWolves

import java.util.*;

public class LittlePigsAndWolves
{

    static int n, m;
    static char[][] grid;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static boolean inside(int i, int j)
    {
        return i > -1 && j > -1 && i < n && j < m;
    }

    public static boolean valid(int i, int j)
    {
        for(int c = 0; c < 4; c++)
            if(inside(i + dx[c], j + dy[c]) && grid[i + dx[c]][j + dy[c]] == 'P')
                return true;
        return false;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][m];
        for(int i = 0; i < n; i++)
            grid[i] = sc.next().toCharArray();

        int count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(grid[i][j] == 'W' && valid(i, j))
                    count++;
        System.out.println(count);
    }
}