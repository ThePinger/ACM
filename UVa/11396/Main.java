//11396
//Claw Decomposition
//Bipartite Graphs

import java.io.*;
import java.util.*;

public class Main
{

    static ArrayList<Integer>[] adjList;

    public static boolean bfs()
    {
        Queue<Integer> queue = new LinkedList<>();
        int[] colouring = new int[adjList.length];
        Arrays.fill(colouring, -1);
        queue.add(1);
        colouring[1] = 1;

        while(!queue.isEmpty())
        {
            int cur = queue.remove();
            for(int nxt : adjList[cur])
            {
                if(colouring[nxt] == -1)
                {
                    colouring[nxt] = 1 - colouring[cur];
                    queue.add(nxt);
                }
                else if(colouring[nxt] == colouring[cur])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        while(true)
        {
            int n = sc.nextInt();
            if(n == 0) break;

            adjList = new ArrayList[n + 1];
            for(int i = 0; i < n + 1; i++)
                adjList[i] = new ArrayList<>();

            while(true)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(x == 0) break;
                adjList[x].add(y);
                adjList[y].add(x);
            }

            if(bfs()) pw.println("YES");
            else pw.println("NO");
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
