//1005B
//Delete from left

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		int i = a.length - 1;
		int j = b.length - 1;
		int count = 0;
		while(i > -1 && j > -1)
		{
			if(a[i--] != b[j--])
			{
				count = i + 2 + j + 2;
				break;
			}
		}
		
		if(i == -1 && j > -1 && count == 0) count += j + 1;
		if(i > -1 && j == -1 && count == 0) count += i + 1;
		
		pw.print(count);
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
