//12442
//Forwarding Emails

import java.util.*;
import java.io.*;

public class Main 
{
    static int[] nodesReach, graph;
    static boolean[] visited;

    public static int dfs(int i)
    {
        visited[i] = true;
        int ans = 0;
        int nxt = graph[i];
        if(!visited[nxt])
            ans = 1 + dfs(nxt);

		visited[i] = false;
        return nodesReach[i] = ans;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        int c = 1;

        while(t-->0)
        {
            int v = sc.nextInt();
            graph = new int[v + 1];
            nodesReach = new int[v + 1];
			visited = new boolean[graph.length];

            while(v-->0)
                graph[sc.nextInt()] = sc.nextInt();

            int idx = 0;
            int max = 0;
            Arrays.fill(nodesReach, -1);
            for(int i = 1; i < graph.length; i++)
            {
                int ans = nodesReach[i];
                if(nodesReach[i] == -1) ans = dfs(i);
                if(ans > max)
                {
                    idx = i;
                    max = ans;
                }
            }

            pw.println("Case " + c++ + ": " + idx);
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