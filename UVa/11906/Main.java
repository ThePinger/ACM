//11906
//Knight in War Grid

import java.util.*;
import java.io.*;

public class Main
{

    static int rows, colu, m, n, even, odds;
    static int[] dx, dy;
    static int[][] cellsReached;
    static boolean[][] water, visited, checked;

    public static boolean isValid(int i, int j)
    {
        return i > -1 && j > -1 && i < rows && j < colu && !water[i][j];
    }

    public static void dfs(int i, int j)
    {
        visited[i][j] = true;
        for(int x = 0; x < 8; x++)
        {
            int nxtI = dx[x] + i;
            int nxtJ = dy[x] + j;
            if(isValid(nxtI, nxtJ) && !checked[nxtI][nxtJ])
            {
                cellsReached[i][j]++;
                checked[nxtI][nxtJ] = true; 
            }
        }

        checked = new boolean[rows][colu];

        for(int x = 0; x < 8; x++)
        {
            int nxtI = dx[x] + i;
            int nxtJ = dy[x] + j;
            if(isValid(nxtI, nxtJ) && !visited[nxtI][nxtJ])
                dfs(nxtI, nxtJ);
        }

        if(cellsReached[i][j] % 2 == 0) even++;
        else odds++;
    }


    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        int c = 1;

        while(t-->0)
        {
            even = 0;
            odds = 0;
            rows = sc.nextInt();
            colu = sc.nextInt();
            m    = sc.nextInt();
            n    = sc.nextInt();
            dx = new int[] {n, n, -n, -n, m, m, -m, -m};
            dy = new int[] {m, -m, m, -m, n, -n, n, -n};
            cellsReached = new int[rows][colu];
            visited = new boolean[rows][colu];
            water   = new boolean[rows][colu];
            checked = new boolean[rows][colu];
            int wat = sc.nextInt();
            while(wat-->0)
                water[sc.nextInt()][sc.nextInt()] = true;

            dfs(0, 0);
            pw.println("Case " + (c++) + ": " + even + " " + odds);
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
