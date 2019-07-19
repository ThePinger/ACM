import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		char[] rotation = sc.next().toCharArray();
		char[][] grid = new char[n][n];
		
		for(int i = 0; i < n; i++)
			grid[i] = sc.next().toCharArray();
		
		int right = 0;
		int left = 0;
		for(int i = 0; i < rotation.length; i++)
			if(rotation[i] == 'R') right++;
			else left++;
		
		boolean directron = true;
		if(left > right)
		{
			left -= right;
			directron = false;
		}
		else
		{
			right -= left;
			directron = true;
		}
		
		char[][] ans = new char[n][n];
		boolean last = true;
		if(directron)
		{
			right %= 4;
			for(int i = 0; i < right; i++)
			{
				if(i % 2 == 0)
				{
					for(int j = 0; j < n; j++)
						for(int c = 0; c < n; c++)
							ans[c][n - j - 1] = grid[j][c] == '>' ? 'v' : grid[j][c] == 'v' ? '<' : grid[j][c] == '<' ? '^' : grid[j][c] == '^' ? '>' : '.';
				}
				else
				{
					for(int j = 0; j < n; j++)
						for(int c = 0; c < n; c++)
							grid[c][n - j - 1] = ans[j][c] == '>' ? 'v' : ans[j][c] == 'v' ? '<' : ans[j][c] == '<' ? '^' : ans[j][c] == '^' ? '>' : '.';
				}
				last = !last;
			}
		}
		else
		{
			left %= 4;
			for(int i = 0; i < left; i++)
			{
				if(i % 2 == 0)
				{
					for(int j = 0; j < n; j++)
						for(int c = 0; c < n; c++)
							ans[n - c - 1][j] = grid[j][c] == '>' ? '^' : grid[j][c] == '^' ? '<' : grid[j][c] == '<' ? 'v' : grid[j][c] == 'v' ? '>' : '.';
				}
				else
				{
					for(int j = 0; j < n; j++)
						for(int c = 0; c < n; c++)
							grid[n - c - 1][j] = ans[j][c] == '>' ? '^' : ans[j][c] == '^' ? '<' : ans[j][c] == '<' ? 'v' : ans[j][c] == 'v' ? '>' : '.';
				}
				last = !last;
			}
		}
		
		if(last)
		{
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
					pw.print(grid[i][j]);
				pw.println();
			}
		}
		else
		{
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
					pw.print(ans[i][j]);
				pw.println();
			}
		}
			
		
		
		pw.flush();
		pw.close();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}

}
