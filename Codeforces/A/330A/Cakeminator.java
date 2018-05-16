//330A
//Cakeminator

import java.util.Scanner;

public class Cakeminator
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        boolean[] rowS = new boolean[row];
        boolean[] colS = new boolean[col];
        char[][] grid = new char[row][col];

        for(int i = 0; i < row; i++)
            grid[i] = sc.next().toCharArray();

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                if(grid[i][j] == 'S')
                {
                    rowS[i] = true;
                    colS[j] = true;
                }

        int cakes = 0;
        for(int i = 0; i < row; i++)
        {
            if(rowS[i]) continue;
            for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == '.')
                {
                    cakes++;
                    grid[i][j] = '#';
                }
            }
        }

        for(int i = 0; i < col; i++)
        {
            if(colS[i]) continue;
            for(int j = 0; j < row; j++)
            {
                if(grid[j][i] == '.')
                {
                    cakes++;
                    grid[j][i] = '#';
                }
            }
        }

        System.out.println(cakes);
    }
}