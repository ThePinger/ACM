//980B
//Marlin

import java.util.Arrays;
import java.util.Scanner;

public class Marlin
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int hotels = sc.nextInt();
        char[][] grid = new char[5][n + 1];

        for(char[] x : grid)
            Arrays.fill(x, '.');

        for(int i = 2; i < 4; i++)
            for(int j = 2; j < n; j++)
                if(hotels > 0 && j <= (n + 1 - j))
                {
                    if(j == (n + 1 - j))
                    {
                        grid[i][j] = '#';
                        hotels--;
                    }
                    else if(hotels > 1)
                    {
                        grid[i][j] = '#';
                        grid[i][n + 1 - j] = '#';
                        hotels -= 2;
                    }
                }

        System.out.println("YES");
        for(int i = 1; i < 5; i++)
        {
            for(int j = 1; j < n + 1; j++)
                System.out.print(grid[i][j]);
            System.out.println();
        }
    }
}