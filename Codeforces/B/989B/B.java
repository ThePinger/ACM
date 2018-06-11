
import java.io.*;
import java.util.*;

public class B
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		char[] s = sc.next().toCharArray();
		boolean flag = false;
		for(int i = 0; i < n; i++)
			if(i + c < n)
			{
				if(s[i] == '.')
				{
					if(s[i + c] == '.')
					{
						s[i] = '1';
						s[i + c] = '0';
					}
					else if(s[i + c] == '1')
						s[i] = '0';
					else
						s[i] = '1';
					flag = true;
				}
				else if(s[i + c] == '.')
				{
					if(s[i] == '1')
						s[i + c] = '0';
					else
						s[i + c] = '1';
					flag = true;
				}
				else if(s[i] != s[i + c])
					flag = true;
			}
			else if(s[i] == '.')
				s[i] = '0';
		if(flag)
			for(int i = 0; i < n; i++)
				System.out.print(s[i]);
		else
			System.out.println("No");
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
