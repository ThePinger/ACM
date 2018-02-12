//60B
//SerialTime

import java.util.*;
import java.io.*;

public class SerialTime
{
    static int k, n, m, filled;
    static char[][][] grid;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    public static boolean isValid(int layer, int x, int y)
    {
        return layer > -1 && x > -1 && y > -1 && layer < k && x < n && y < m && grid[layer][x][y] == '.';
    }
    
    public static void dfs(int layer, int x, int y)
    {
        filled++;
        grid[layer][x][y] = 'X';
        for(int i = 0; i < 6; i++)
        {
            int nxtX = x + dx[i];
            int nxtY = y + dy[i];
            int nxtZ = layer + dz[i];

            if(isValid(nxtZ, nxtX, nxtY))
                dfs(nxtZ, nxtX, nxtY);
        }

    }


    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[k][n][m];

        for(int i = 0; i < k; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.next().toCharArray();

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;
        dfs(0, startX, startY);
        System.out.println(filled);
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