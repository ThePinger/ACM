//10667
//LargestBlock

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter    pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while(t-->0)
        {
            int board = Integer.parseInt(br.readLine());
            int[][] grid = new int[board + 1][board + 1];
            int blocks = Integer.parseInt(br.readLine());

            for(int[] arr : grid)
                Arrays.fill(arr, 1);

            for(int i = 0; i < blocks; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int startX = Integer.parseInt(st.nextToken());
                int startY = Integer.parseInt(st.nextToken());
                int endX   = Integer.parseInt(st.nextToken());
                int endY   = Integer.parseInt(st.nextToken());
                for(int c = startX; c < endX + 1; c++)
                    for(int cc = startY; cc < endY + 1; cc++)
                        grid[c][cc] = -10000;
            }

            for(int i = 1; i < board + 1; i++)
                for(int j = 1; j < board + 1; j++)
                {
                    if(j > 1)
                        grid[i][j] += grid[i][j - 1]; 
                    if(i > 1)
                        grid[i][j] += grid[i - 1][j];
                    if(i > 1 && j > 1)
                        grid[i][j] -= grid[i - 1][j - 1];
                }

            int max = 0;
            for(int i = 1; i < board + 1; i++)
                for(int j = 1; j < board + 1; j++)
                    for(int ii = i; ii < board + 1; ii++)
                        for(int jj = j; jj < board + 1; jj++)
                        {
                            int ans = grid[ii][jj];
                            if(j > 1) ans -= grid[ii][j - 1];
                            if(i > 1) ans -= grid[i - 1][jj];
                            if(i > 1 && j > 1) ans += grid[i - 1][j - 1];
                            max = Math.max(max, ans);
                        }
                        
            pw.println(max);
        }
        pw.flush();
        pw.close();
    }
}