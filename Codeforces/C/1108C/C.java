
import java.io.*;
import java.util.*;

public class C
{
	
	static int n;
	static char[] s;
	static int[][][][] memo;
	static PrintWriter pw = new PrintWriter(System.out);

	
	public static int dp(int idx, int r, int g, int b)
	{
		if(idx == n) return 0;
		
		if(memo[idx][r][g][b] != -1) 
			return memo[idx][r][g][b];
		
		int red   = Integer.MAX_VALUE;
		int green = Integer.MAX_VALUE;
		int blue  = Integer.MAX_VALUE;
		if(r == 0)
		{
			if(g == 0 && b == 0)
			{
				red   = (s[idx] == 'R' ? 0 : 1) + dp(idx + 1, 2, 0, 0);
				green = (s[idx] == 'G' ? 0 : 1) + dp(idx + 1, 0, 2, 0);
				blue  = (s[idx] == 'B' ? 0 : 1) + dp(idx + 1, 0, 0, 2);
			}
			else if(g == 0)
			{
				red   = (s[idx] == 'R' ? 0 : 1) + dp(idx + 1, 2, 0, b - 1);
				green = (s[idx] == 'G' ? 0 : 1) + dp(idx + 1, 0, 2, b - 1);
			}
			else if(b == 0)
			{
				red   = (s[idx] == 'R' ? 0 : 1) + dp(idx + 1, 2, g - 1, 0);
				blue  = (s[idx] == 'B' ? 0 : 1) + dp(idx + 1, 0, g - 1, 2);
			}
			else
				red   = (s[idx] == 'R' ? 0 : 1) + dp(idx + 1, 2, g - 1, b - 1);
		}
		else if(g == 0)
		{
			if(b == 0)
			{
				green = (s[idx] == 'G' ? 0 : 1) + dp(idx + 1, r - 1, 2, 0);
				blue  = (s[idx] == 'B' ? 0 : 1) + dp(idx + 1, r - 1, 0, 2);
			}
			else
				green = (s[idx] == 'G' ? 0 : 1) + dp(idx + 1, r - 1, 2, b - 1);
		}
		else
			blue  = (s[idx] == 'B' ? 0 : 1) + dp(idx + 1, r - 1, g - 1, 2);

		return memo[idx][r][g][b] = Math.min(red, Math.min(green, blue));
	}
	
	public static void print(int idx, int r, int g, int b)
	{
		if(idx == n) return;

		int red   = Integer.MAX_VALUE;
		int green = Integer.MAX_VALUE;
		int blue  = Integer.MAX_VALUE;
		if(r == 0)
		{
			if(g == 0 && b == 0)
			{
				red   = (s[idx] == 'R' ? 0 : 1) + dp(idx + 1, 2, 0, 0);
				green = (s[idx] == 'G' ? 0 : 1) + dp(idx + 1, 0, 2, 0);
				blue  = (s[idx] == 'B' ? 0 : 1) + dp(idx + 1, 0, 0, 2);
				
				if(red == memo[idx][r][g][b])
				{
					pw.print('R');
					print(idx + 1, 2, 0, 0);
				}
				else if(green == memo[idx][r][g][b])
				{
					pw.print('G');
					print(idx + 1, 0, 2, 0);
				}
				else
				{
					pw.print('B');
					print(idx + 1, 0, 0, 2);
				}
			}
			else if(g == 0)
			{
				red   = (s[idx] == 'R' ? 0 : 1) + dp(idx + 1, 2, 0, b - 1);
				green = (s[idx] == 'G' ? 0 : 1) + dp(idx + 1, 0, 2, b - 1);
				
				if(red == memo[idx][r][g][b])
				{
					pw.print('R');
					print(idx + 1, 2, 0, b - 1);
				}
				else
				{
					pw.print('G');
					print(idx + 1, 0, 2, b - 1);
				}
			}
			else if(b == 0)
			{
				red   = (s[idx] == 'R' ? 0 : 1) + dp(idx + 1, 2, g - 1, 0);
				blue  = (s[idx] == 'B' ? 0 : 1) + dp(idx + 1, 0, g - 1, 2);
				
				if(red == memo[idx][r][g][b])
				{
					pw.print('R');
					print(idx + 1, 2, g - 1, 0);
				}
				else
				{
					pw.print('B');
					print(idx + 1, 0, g - 1, 2);
				}
			}
			else
			{
				pw.print('R');
				print(idx + 1, 2, g - 1, b - 1);
			}
		}
		else if(g == 0)
		{
			if(b == 0)
			{
				green = (s[idx] == 'G' ? 0 : 1) + dp(idx + 1, r - 1, 2, 0);
				blue  = (s[idx] == 'B' ? 0 : 1) + dp(idx + 1, r - 1, 0, 2);
				
				if(blue == memo[idx][r][g][b])
				{
					pw.print('B');
					print(idx + 1, r - 1, 0, 2);
				}
				else
				{
					pw.print('G');
					print(idx + 1, r - 1, 2, 0);
				}
			}
			else
			{
				pw.print('G');
				print(idx + 1, r - 1, 2, b - 1);
			}
		}
		else
		{
			pw.print('B');
			print(idx + 1, r - 1, g - 1, 2);
		}
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.next().toCharArray();
		memo = new int[n][3][3][3];
		
		for(int[][][] xxx : memo)
			for(int[][] xx : xxx)
				for(int[] x : xx)
					Arrays.fill(x, -1);
		
		pw.println(dp(0, 0, 0, 0));
		print(0, 0, 0, 0);
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
