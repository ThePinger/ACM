//427E
//PolicePatrol

import java.util.*;
import java.io.*;

public class PolicePatrol
{
    static int criminals;
    static int[] pos;

    public static long distance(int start)
    {
        long total = 0;
        for(int i = pos.length - 1; i > start; i -= criminals)
            if(pos[i] != pos[start])
                total += Math.abs(pos[i] - pos[start]) * 2l;

        for(int i = 0; i < start; i += criminals)
            if(pos[i] != pos[start])
                total += Math.abs(pos[i] - pos[start]) * 2l;

        return total;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        criminals = sc.nextInt();
        pos = new int[n];

        for(int i = 0; i < n; i++)
            pos[i] = sc.nextInt();

        int lo = 0;
        int hi = n - 1;
        long ans = (long) 1e18;
        while(hi - lo > 3 || (lo <= hi && n < 5))
        {
            int mid1 = lo + (hi - lo) / 3;
            int mid2 = lo + (2 * (hi - lo)) / 3;
            long dist1 = distance(mid1);
            long dist2 = distance(mid2);

            if(dist1 > dist2)
                lo = mid1 + 1;
            else
                hi = mid2 - 1;

            ans = Math.min(ans, Math.min(dist1, dist2));
        }

        System.out.println(ans);
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