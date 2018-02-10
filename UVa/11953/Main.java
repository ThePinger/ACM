//11953
//BattleShips

import java.util.*;
import java.io.*;

public class Main 
{
    static int n, notDamaged;
    static char[][] grid;
    static boolean[][] vis;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static boolean valid(int i, int j)
    {
        return i > -1 && j > -1 && i < n && j < n && !vis[i][j] && grid[i][j] != '.';
    }

    public static void dfs(int i, int j, int preI, int preJ, int size)
    {
        vis[i][j] = true;
        if(grid[i][j] == 'x') notDamaged++;
        for(int c = 0; c < 4; c++)
        {
            int x = i + dx[c];
            int y = j + dy[c];
            if(valid(x, y) && ((preI == dx[c] && preJ == dy[c]) || (preI == 0 && preJ == 0)) && size < n / 2)
                dfs(x, y, dx[c], dy[c], size + 1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        int c = 1;

        while(t-->0)
        {
            n = sc.nextInt();
            grid = new char[n][n];
            vis  = new boolean[n][n];
            for(int i = 0; i < n; i++)
                grid[i] = sc.nextLine().toCharArray();

            int safe = 0;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                {
                    if(valid(i, j)) dfs(i, j, 0, 0, 1);
                    if(notDamaged > 0) safe++;
                    notDamaged = 0;
                }

            pw.println("Case " + (c++) + ": " + safe);
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