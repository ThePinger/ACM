//11520
//Fill The Square

import java.io.*;

public class Main 
{
    static char[][] grid;
    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};

    public static boolean isValid(int i, int j)
    {
        return i > -1 && j > -1 && i != grid.length && j != grid.length;
    }

    public static char getCharacter(int i, int j)
    {
        loop : for(int c = 'A'; c < 'Z'; c++)
        {
            for(int cc = 0; cc < 4; cc++)
                if(isValid(i + x[cc], j + y[cc]))
                    if(grid[i + x[cc]][j + y[cc]] == c)
                        continue loop;
            return (char) c;
        }
        
        return 'Z';
    }

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int t = 1;
        
        while(n-->0)
        {
            int dimension = Integer.parseInt(br.readLine());
            grid = new char[dimension][];
            for(int i = 0; i < dimension; i++)
                grid[i] = br.readLine().toCharArray();

            for(int i = 0; i < dimension; i++)
                for(int j = 0; j < dimension; j++)
                    if(grid[i][j] == '.')
                        grid[i][j] = getCharacter(i, j);

            sb.append("Case " + (t++) + ":\n");
            for(int i = 0; i < dimension; i++)
            {
                for(int j = 0; j < dimension; j++)
                    sb.append(grid[i][j]);
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}