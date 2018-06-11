
import java.io.*;
import java.util.*;

public class A 
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		
		boolean flag = false;
		for(int i = 1; i < s.length - 1; i++)
			if(s[i - 1] != '.' && s[i] != '.' && s[i + 1] != '.')
			{
				if(s[i - 1] != s[i] && s[i - 1] != s[i + 1] && s[i] != s[i + 1])
					flag = true;
			}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
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
