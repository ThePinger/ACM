//10360
//Rat Attack


import java.util.*;
import java.io.*;

public class Main 
{
    static int d, x, y, size;
    static int[][] killed;

    public static void kill()
    {
        for(int i = Math.max(x - d, 0); i <= Math.min(x + d, 1024); i++)
            for(int j = Math.max(y - d, 0); j <= Math.min(y + d, 1024); j++)
                killed[i][j] += size;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-->0)
        {
            d = Integer.parseInt(br.readLine());
            int pop = Integer.parseInt(br.readLine());
            killed = new int[1025][1025];
            while(pop-->0)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                size = Integer.parseInt(st.nextToken());
                kill();
            }

            int maxX = 0;
            int maxY = 0;
            int max = 0;
            for(int i = 0; i < 1025; i++)
                for(int j = 0; j < 1025; j++)
                    if(killed[i][j] > max)
                    {
                        maxX = i;
                        maxY = j;
                        max = killed[i][j];
                    }
            
            sb.append(maxX + " " + maxY + " " + max);
            if(n > 0) sb.append("\n");
        }
        System.out.println(sb);
    }
}