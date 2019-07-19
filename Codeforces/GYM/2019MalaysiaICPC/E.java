import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

	static int[] reservations;
	static int[][] memo;
	static PrintWriter pw;
	
	public static int dp(int idx, int remHours)
	{
		if(idx == reservations.length)
			return remHours;
		
		if(memo[idx][remHours] != -1)
			return memo[idx][remHours];
		
		int take = reservations[idx] <= remHours ? dp(idx + 1, remHours - reservations[idx]) : Integer.MAX_VALUE;
		int leave = dp(idx + 1, remHours);
		
		return memo[idx][remHours] = Math.min(take, leave);
	}
	
	public static void print(int idx, int remHours)
	{
		if(idx == reservations.length)
			return;
		
		int take = reservations[idx] <= remHours ? dp(idx + 1, remHours - reservations[idx]) : Integer.MAX_VALUE;		
		if(memo[idx][remHours] == take)
		{
			pw.print(reservations[idx] + " ");
			print(idx + 1, remHours - reservations[idx]);
		}
		else print(idx + 1, remHours);
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		while(true)
		{
			int t = sc.nextInt();
			if(t == 0) break;
			
			int n = sc.nextInt();
			reservations = new int[n];
			for(int i = 0; i < n; i++)
				reservations[i] = sc.nextInt();
			
			memo = new int[n][t + 1];
			for(int[] x : memo)
				Arrays.fill(x, -1);
			
			int hours = t - dp(0, t);
			print(0, t);
			pw.println(hours);
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
