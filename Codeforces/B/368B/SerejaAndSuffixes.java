//368B
//Sereja and Suffixes

import java.io.*;
import java.util.*;

public class SerejaAndSuffixes
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] distinct = new int[n];
        int[] arr = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            arr[i] = tmp;
            if(map.containsKey(tmp))
                map.put(tmp, map.get(tmp) + 1);
            else
                map.put(tmp, 1);
        }
    
        for(int i = 0; i < n; i++)
        {
            distinct[i] = map.size();
            if(map.get(arr[i]) == 1)
                map.remove(arr[i]);
            else
                map.put(arr[i], map.get(arr[i]) - 1);
        }

        for(int i = 0; i < m; i++)
            System.out.println(distinct[sc.nextInt() - 1]);
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