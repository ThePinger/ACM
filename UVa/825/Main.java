//825
//Walking on the Safe Side

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

            boolean[][] notSafe = new boolean[n][m];
            for(int i = 0; i < n; i++)
            {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                int cur = Integer.parseInt(st.nextToken()) - 1;
                while(st.hasMoreTokens())
                    notSafe[cur][Integer.parseInt(st.nextToken()) - 1] = true;
            }

            int[][] dp = new int[n][m];
            dp[n - 1][m - 1] = 1;
            for(int i = n - 1; i > -1; i--)
            {
                for(int j = m - 1; j > -1; j--)
                {
                    if(i + 1 < n && j + 1 < m)
                    {
                        if(!notSafe[i + 1][j])
                            dp[i][j] = dp[i + 1][j];
                        if(!notSafe[i][j + 1])
                            dp[i][j] += dp[i][j + 1];
                    }
                    else if(i + 1 < n && !notSafe[i + 1][j])
                        dp[i][j] = dp[i + 1][j];
                    else if(j + 1 < m && !notSafe[i][j + 1])
                        dp[i][j] = dp[i][j + 1]; 
                }
            }
            
            pw.println(dp[0][0]);
            if(t > 0) pw.println();
        }

        pw.flush();
        pw.close();
    }

    static class Scanner 
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException 
        {
            while (st == null || !st.hasMoreTokens()) 
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}
        
        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}
        
        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }
        
        public boolean ready() throws IOException {return br.ready();}

    }
}