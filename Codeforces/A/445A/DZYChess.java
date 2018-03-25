//445A
//DZY Loves Chessboard

import java.util.Scanner;

public class DZYChess
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        
        for(int i = 0; i < n; i++)
            grid[i] = sc.next().toCharArray();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '-') continue;
                if((i + j) % 2 == 0) grid[i][j] = 'B';
                else grid[i][j] = 'W';
            }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                System.out.print(grid[i][j]);
            System.out.println();
        }
    }
}