//275A
//Lights Out

import java.util.*;

public class LightsOut
{
    static int[] xx = {0, 0, 0, 1, -1};
    static int[] yy = {0, -1, 1, 0, 0};

    public static boolean isValid(int i, int j)
    {
        return i > -1 && j > -1 && i != 3 && j != 3;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[][] grid = new int[3][3];
        
        for(int[] x : grid)
            Arrays.fill(x, 1);
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                int switches = sc.nextInt();
                for(int c = 0; c < 5; c++)
                {
                    int dx = i + xx[c];
                    int dy = j + yy[c];
                    if(isValid(dx, dy))
                        if(switches % 2 != 0)
                            grid[dx][dy] = 1 - grid[dx][dy];
                }
                
            }
        }

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                sb.append(grid[i][j]);
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}