//507
//Jill Rides again

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        for(int c = 1; c <= t; c++)
        {
            int stops = sc.nextInt();
            long total = 0;
            int start = 0;
            int end = 0;
            int tmpS = 1;
            long max = 0;
            for(int i = 1; i < stops; i++)
            {
                total += sc.nextInt();
                if(total > max)
                {
                    start = tmpS;
                    end = i + 1;
                    max = total;
                }
                else if(total == max && (i - tmpS + 2) > (end - start + 1))
                {
                    start = tmpS;
                    end = i + 1;
                }
                else if(total < 0)
                {
                    total = 0;
                    tmpS = i + 1;
                }
            }

            if(max > 0)
                pw.println("The nicest part of route " + c + " is between stops " + start + " and " + end);
            else
                pw.println("Route " + c + " has no nice parts");
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