//11003
//Boxes

import java.io.*;
import java.util.*;

public class Main
{
    static int n;
    static int[] weight, load;
    static int[][] memo;

    public static int dp(int idx, int curLoad, boolean start)
    {
        if(curLoad < 0) 
            return Integer.MIN_VALUE;
        if(idx == n) 
            return 0;
        if(curLoad == 0 && start) 
            return 0;
        if(memo[idx][curLoad] != -1)
            return memo[idx][curLoad];

        int take;
        if(start)
            take = 1 + dp(idx + 1, Math.min(curLoad - weight[idx], load[idx]), start);
        else 
            take = 1 + dp(idx + 1, load[idx], true);

        int leave = dp(idx + 1, curLoad, start);

        return memo[idx][curLoad] = Math.max(take, leave);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        while(true)
        {
            n = sc.nextInt();
            if(n == 0) break;

            load = new int[n];
            weight = new int[n];
            memo = new int[n][3001];

            for(int i = 0; i < n; i++)
            {
                weight[i] = sc.nextInt();
                load[i] = sc.nextInt();
            }

            for(int[] x : memo)
                Arrays.fill(x, -1);

            int max = dp(0, 0, false);
            pw.println(max);
        }

        pw.flush();
        pw.close();
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s)
        {
          br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String s) throws FileNotFoundException
        {
          br = new BufferedReader(new FileReader(new File((s))));
        }

        public String next() throws IOException
        {
          while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
          return st.nextToken();
        }

        public int nextInt() throws IOException
        {
          return Integer.parseInt(next());
        }

        public long nextLong() throws IOException
        {
          return Long.parseLong(next());
        }

        public String nextLine() throws IOException
        {
          return br.readLine();
        }

        public double nextDouble() throws IOException
        {
          String x = next();
          StringBuilder sb = new StringBuilder("0");
          double res = 0, f = 1;
          boolean dec = false, neg = false;
          int start = 0;
          if (x.charAt(0) == '-')
          {
            neg = true;
            start++;
          }
          for (int i = start; i < x.length(); i++)
            if (x.charAt(i) == '.')
            {
              res = Long.parseLong(sb.toString());
              sb = new StringBuilder("0");
              dec = true;
            } else
            {
              sb.append(x.charAt(i));
              if (dec)
                f *= 10;
            }
          res += Long.parseLong(sb.toString()) / f;
          return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException
        {
          return br.ready();
        }
    }
}
