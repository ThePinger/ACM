//10525
//New to Bangladesh?

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);  

        int t = sc.nextInt();

        while(t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] time = new int[n][n];
            int[][] dist = new int[n][n];

            int INF = (int) 1e8;
            for(int[] tmp : time) Arrays.fill(tmp, INF);
            for(int[] tmp : dist) Arrays.fill(tmp, INF);

            for(int i = 0; i < m; i++)
            {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int tim = sc.nextInt();
                int dis = sc.nextInt();
                if(tim < time[a][b] || (tim == time[a][b] && dis < dist[a][b]))
                {
                    time[a][b] = time[b][a] = tim;
                    dist[a][b] = dist[b][a] = dis;
                }
            }

            for(int i = 0; i < n; i++)
                time[i][i] = dist[i][i] = 0;

            for(int k = 0; k < n; k++)
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++)
                        if(time[i][k] + time[k][j] < time[i][j] || (time[i][k] + time[k][j] == time[i][j] && dist[i][k] + dist[k][j] < dist[i][j]))
                        {
                            time[i][j] = time[i][k] + time[k][j];
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }

            int q = sc.nextInt();
            while(q-->0)
            {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                if(time[a][b] < INF)
                    pw.println("Distance and time to reach destination is " + dist[a][b] + " & " + time[a][b] + ".");
                else pw.println("No Path.");
            }

            if(t > 0) pw.println();
        }

        pw.flush();
        pw.close();
    }
}
