//562
//Dividing Coins

import java.io.*;
import java.util.*;

public class Main 
{

    static int coins;
    static int[] values;
    static int[][][] memo;

    public static int dp(int idx, int greater, int diff)
    {
        if(idx == coins) return diff;
        if(memo[idx][greater][diff] != -1)
            return memo[idx][greater][diff];

        int first, second;
        if(diff - values[idx] < 0)
            second = dp(idx + 1, 1 - greater, Math.abs(diff - values[idx]));
        else
            second = dp(idx + 1, greater, diff - values[idx]);

        first = dp(idx + 1, greater, diff + values[idx]);
        return memo[idx][greater][diff] = Math.min(first, second);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            coins = sc.nextInt();
            values = new int[coins];
            memo   = new int[coins][2][50001];

            for(int i = 0; i < coins; i++)
                values[i] = sc.nextInt();

            for(int[][] x : memo)
                for(int[] xx : x)
                    Arrays.fill(xx, -1);

            pw.println(dp(0, 0, 0));
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
