//287A
//IQTest

import java.util.Scanner;

public class IQTest
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[4][4];

        for(int i = 0; i < 4; i++)
            grid[i] = sc.next().toCharArray();

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                int hash = 0;
                int dot  = 0;
                if(grid[i][j] == '#') hash++;
                else dot++;

                if(grid[i][j + 1] == '#') hash++;
                else dot++;

                if(grid[i + 1][j] == '#') hash++;
                else dot++;

                if(grid[i + 1][j + 1] == '#') hash++;
                else dot++;

                if(hash > 2 || dot > 2)
                {
                    System.out.println("YES");    
                    return;
                }
            }
        }

        System.out.println("NO");
    }
}