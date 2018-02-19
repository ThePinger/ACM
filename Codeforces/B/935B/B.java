
import java.io.*;
import java.util.*;

public class B 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] path = sc.next().toCharArray();
		long x = 0;
		long y = 0;
		long coins = 0;
		if(path[0] == 'U') y++;
		else x++;
		
		for(int i = 1; i < n; i++)
		{
			if(path[i] == 'U')
			{
				if(i != 0 && x == y && path[i - 1] == 'U')
				{
					coins++;
				}
				y++;
			}
			else
			{
				if(i != 0 && x == y && path[i - 1] == 'R')
				{
					coins++;
				}
				x++;
			}
		}
		System.out.println(coins);
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
