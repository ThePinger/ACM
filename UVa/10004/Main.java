//10004
//BiColouring

import java.io.*;
import java.util.*;

public class Main 
{

    static int n;
    static ArrayList<Integer>[] adjList;

    public static boolean bfs()
    {
        Queue<Integer> q = new LinkedList<>();
        int[] colour = new int[n];
        Arrays.fill(colour, -1);

        colour[0] = 1;
        q.add(0);

        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(int nxt : adjList[cur])
                if(colour[nxt] == -1)
                {
                    colour[nxt] = 1 - colour[cur];
                    q.add(nxt);
                }
                else if(colour[nxt] == colour[cur])
                    return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out); 

        while(true)
        {
            n = sc.nextInt();
            if(n == 0) break;
            int e = sc.nextInt();

            adjList = new ArrayList[n];

            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            while(e-->0)
            {
                int e1 = sc.nextInt();
                int e2 = sc.nextInt();
                adjList[e1].add(e2);
                adjList[e2].add(e1);
            }

            if(bfs()) pw.println("BICOLORABLE.");
            else pw.println("NOT BICOLORABLE.");
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
