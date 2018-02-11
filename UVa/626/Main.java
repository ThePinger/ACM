//626
//EcoSystem

import java.io.*;
import java.util.*;

public class Main 
{

    static boolean[][] visited;
    static boolean[][][] added;
    static ArrayList<Integer>[] adjList;
    static PriorityQueue<Chain> ans;
    static int chains;

    public static void dfs(int cur, int first, int sec, int third)
    {
        if(first == -1) first = cur;
        else if(sec == -1) sec = cur;
        else third = cur;

        for(int nxt : adjList[cur])
        {
            if(!visited[cur][nxt] && third == -1)
            {
                visited[cur][nxt] = true;
                dfs(nxt, first, sec, third);
            }
            if(third != -1 && first == nxt)
            {
                if(!added[first][sec][third] && !added[third][first][sec] && !added[sec][third][first])
                {
                    ans.add(new Chain(first, sec, third));
                    added[first][sec][third] = true;
                    chains++;                  
                }
                break;
            }

        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.ready())
        {
            int n = sc.nextInt();
            adjList = new ArrayList[n + 1];
            added   = new boolean[101][101][101];
            ans = new PriorityQueue<>();

            for(int i = 0; i < n + 1; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 1; i < n + 1; i++)
            {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                for(int j = 1; j < n + 1; j++)
                    if(st.nextToken().equals("1") && i != j)
                        adjList[i].add(j);
            }

            chains = 0;
            for(int i = 1; i < n + 1; i++)
            {
                visited = new boolean[n + 1][n + 1];
                dfs(i, -1, -1, -1);
            }

            while(!ans.isEmpty())
            {
                Chain tmp = ans.poll();
                pw.println(tmp.x + " " + tmp.y + " " + tmp.z);
            }

            pw.println("total:" + chains);
            pw.println();
        }

        pw.flush();
        pw.close();
    }

    static class Chain implements Comparable<Chain>
    {
        int x, y, z;

        Chain(int x, int y, int z)
        {
            if(y > x && y > z)
            {
                if(z > x)
                {
                    this.x = y;
                    this.y = z;
                    this.z = x;
                }
                else
                {
                    this.x = z;
                    this.y = x;
                    this.z = y;
                }
            }
            else if(z > x && z > y && x > y)
            {
                this.x = z;
                this.y = x;
                this.z = y;
            }
            else if(x > y && x > z && z > y)
            {
                this.x = y;
                this.y = z;
                this.z = x;
            }
            else
            {
                this.x = x;
                this.y = y;
                this.z = z;
            }
        }

        public int compareTo(Chain cmp)
        {
            if(x != cmp.x) return x - cmp.x;
            if(y != cmp.y) return y - cmp.y;
            return z - cmp.z;
        }

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
