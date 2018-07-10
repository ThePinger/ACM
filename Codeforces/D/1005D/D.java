//1005D
//Polycarp and Div 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		char[] line = sc.next().toCharArray();
		int[] arr = new int[line.length];
		for(int i = 0; i < line.length; i++)
			arr[i] = Character.getNumericValue(line[i]);
		
		int[][] memo = new int[arr.length][3];
		for(int i = 0; i < 3; i++)
			if((i + arr[arr.length - 1]) % 3 == 0)
				memo[arr.length - 1][i] = 1;
		
		for(int i = arr.length - 2; i > -1; i--)
		{
			for(int cur = 0; cur < 3; cur++)
			{
				int ans = 0;
				if((cur + arr[i]) % 3 == 0 || arr[i] % 3 == 0)
					ans = 1 + memo[i + 1][0];
				ans = Math.max(ans, memo[i + 1][(arr[i] + cur) % 3]);
				ans = Math.max(ans, memo[i + 1][cur % 3]);
				memo[i][cur] = ans;
			}
		}
		
		pw.println(memo[0][0]);
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
