
import java.util.*;
import java.io.*;

public class A
{
    static boolean[] vis;
    static int[] taps;

    public static boolean ok(int time)
    {
        for(int i = 0; i < taps.length; i++)
        {
            int tp = taps[i];

            for(int j = Math.max(0, tp - (time - 1)); j <= Math.min(tp + (time - 1), vis.length - 1); j++)
                vis[j] = true;
        }

        for(int i = 0; i < vis.length; i++)
            if(!vis[i])
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            taps = new int[k];

            for(int i = 0; i< k; i++)
                taps[i] = sc.nextInt() - 1;

            int lo = 1;
            int hi = (int) 1e7;
            int ans = (int) 1e7;
            while(lo <= hi)
            {
                int mid = (lo + hi) / 2;
                vis = new boolean[n];
                if(ok(mid))
                {
                    hi = mid - 1;
                    ans = Math.min(ans, mid);
                }
                else
                    lo = mid + 1;
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