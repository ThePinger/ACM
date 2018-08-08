//10000
//LongestPaths

import java.io.*;
import java.util.*;

public class Main
{

    static int[] memo;
    static ArrayList<Integer>[] adjList;

    public static int dp(int cur)
    {
        if(adjList[cur].isEmpty()) return 0;
        if(memo[cur] != -1) return memo[cur];

        int max = 0;
        for(int nxt : adjList[cur])
            max = Math.max(max, 1 + dp(nxt));

        return memo[cur] = max;
    }

    public static int trace(int cur)
    {
        if(adjList[cur].isEmpty()) return cur;

        int min = Integer.MAX_VALUE;
        for(int nxt : adjList[cur])
            if(memo[cur] == 1 + dp(nxt))
                min = Math.min(min, trace(nxt));
        
        return min;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = 1;
        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            int source = sc.nextInt() - 1;
            while(true)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if(a == 0 && b == 0) break;

                adjList[a - 1].add(b - 1);
            }

            memo = new int[n];
            Arrays.fill(memo, -1);

            int dist = dp(source);
            int dest = trace(source);
            pw.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n", t++, source + 1, dist, dest + 1);
        }

        pw.flush();
        pw.close();
    }
}