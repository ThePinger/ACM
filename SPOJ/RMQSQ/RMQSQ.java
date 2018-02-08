//RMQSQ

import java.util.*;
import java.io.*;

public class RMQSQ
{
    static int n;
    static int[] arr;
    static int[][] spt;

    public static void fillSPT()
    {
        int k = (int) Math.ceil(Math.log(n) / Math.log(2));
        spt = new int[n][k];

        for(int i = 0; i < n; i++)
            spt[i][0] = arr[i];

        for(int j = 1; j < k; j++)
            for(int i = 0; i + (1 << j) - 1 < n; i++)
                spt[i][j] = Math.min(spt[i][j - 1], spt[i + (1 << (j - 1))][j - 1]);
    }

    public static int rmq(int start, int end)
    {
        int k = (int) Math.floor(Math.log(end - start + 1) / Math.log(2));
        return Math.min(spt[start][k], spt[end - (1 << k) + 1][k]);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        fillSPT();

        int query = sc.nextInt();
        while(query-->0)
            pw.println(rmq(sc.nextInt(), sc.nextInt()));

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