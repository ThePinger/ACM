
import java.util.*;
import java.io.*;

public class C
{
    static char[][] grid;
    static int k;

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        k = sc.nextInt();
        grid = new char[n][m];
        for(int i = 0; i < n; i++)
            grid[i] = sc.next().toCharArray();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        long ways = 0;
        for(int i = 0; i < n; i++)
        {
            int tot = 0;
            for(int j = 0; j < m; j++)
                if(grid[i][j] == '.')
                    tot++;
                else
                {
                    if(tot != 0) pq.add(tot);
                    tot = 0;
                }

            if(tot != 0) pq.add(tot);
            while(!pq.isEmpty())
            {
                int tmp = pq.poll();
                if(tmp < k) continue;
                else if(tmp == k) ways++;
                else ways += tmp - k + 1;
            }
        }

        if(k != 1)
        {
            for(int i = 0; i < m; i++)
            {
                int tot = 0;
                for(int j = 0; j < n; j++)
                    if(grid[j][i] == '.')
                        tot++;
                    else
                    {
                        if(tot != 0) pq.add(tot);
                        tot = 0;
                    }

                if(tot != 0) pq.add(tot);
                while(!pq.isEmpty())
                {
                    int tmp = pq.poll();
                    if(tmp < k) continue;
                    else if(tmp == k) ways++;
                    else ways += tmp - k + 1;
                }
            }
        }
        
        System.out.println(ways);
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