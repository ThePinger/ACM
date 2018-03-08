//10505
//Montesco vs Capuleto

import java.io.*;
import java.util.*;

public class Main
{

    static int n, first, second;
    static int[] colouring;
    static ArrayList<Integer>[] adjList;

    public static void bfs(int i)
    {
        Queue<Integer> queue = new LinkedList<>();
        boolean notPossible = false;
        queue.add(i);
        colouring[i] = 0;
        first++;

        while(!queue.isEmpty())
        {
            int cur = queue.remove();
            for(int nxt : adjList[cur])
                if(colouring[nxt] == -1)
                {
                    queue.add(nxt);
                    colouring[nxt] = 1 - colouring[cur];
                    if(colouring[nxt] == 0) first++;
                    else second++;
                }
                else if(colouring[nxt] == colouring[cur])
                    notPossible = true;
        }
        if(notPossible)
        {
            first = 0;
            second = 0;
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            sc.nextLine();
            n = sc.nextInt() + 1;
            first = 0;
            second = 0;
            adjList = new ArrayList[n];
            colouring = new int[n];
            Arrays.fill(colouring, -1);
            for(int i = 1; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 1; i < n; i++)
            {
                int enemies = sc.nextInt();
                while(enemies-->0)
                {
                    int e = sc.nextInt();
                    if(e >= n) continue;
                    adjList[i].add(e);
                    adjList[e].add(i);
                }
            }

            int ans = 0;
            for(int i = 1; i < n; i++)
                if(colouring[i] == -1)
                {
                    first = 0;
                    second = 0;
                    bfs(i);
                    ans += Math.max(first, second);
                }

            pw.println(ans);
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
