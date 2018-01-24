
import java.util.*;
import java.io.*;
import java.awt.Point;

public class D
{
    static int[][] grid;
    static Point[] start;

    public static boolean sumOk()
    {
        for(int c = 0; c < 9; c++)
        {
            Point st = start[c];
            boolean[] vis = new boolean[10];
            for(int i = st.x; i < st.x + 3; i++)
                for(int j = st.y; j < st.y + 3; j++)
                    if(!vis[grid[i][j]])
                        vis[grid[i][j]] = true;
                    else
                        return false;
        }
        return true;
    }

    public static boolean rowColOk()
    {
        for(int i = 0; i < 9; i++)
        {
            boolean[] vis = new boolean[10];
            for(int j = 0; j < 9; j++)
                if(!vis[grid[i][j]])
                    vis[grid[i][j]] = true;
                else
                    return false;
        }

        for(int i = 0; i < 9; i++)
        {
            boolean[] vis = new boolean[10];
            for(int j = 0; j < 9; j++)
                if(!vis[grid[j][i]])
                    vis[grid[j][i]] = true;
                else
                    return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(sc.readLine());

        while(n-->0)
        {
            grid = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                char[] a = sc.readLine().toCharArray();
                for(int j = 0; j < 9; j++)
                    grid[i][j] = Character.getNumericValue(a[j]);
            }

            start = new Point[9];
            start[0] = new Point(0,0);
            start[1] = new Point(0,3);
            start[2] = new Point(0,6);
            start[3] = new Point(3,0);
            start[4] = new Point(3,3);
            start[5] = new Point(3,6);
            start[6] = new Point(6,0);
            start[7] = new Point(6,3);
            start[8] = new Point(6,6);

            if(rowColOk() && sumOk())
                pw.println("Valid");
            else
                pw.println("Invalid");
            
            if(n > 0) sc.readLine();
        }
         
        pw.flush();
        pw.close();
    }
}