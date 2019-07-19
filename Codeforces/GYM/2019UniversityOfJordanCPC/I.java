import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I 
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
			
		
		int n = sc.nextInt();
		char[] line = sc.next().toCharArray();
		int[] parent = new int[n + 1];
		
		int cur = 0;
		for(int i = 0; i < line.length;)
		{
			if(line[i] == '(') i++;
			
			String number = "";
			while(i < line.length && line[i] >= '0' && line[i] <= '9')
				number += line[i++];
			
			parent[Integer.parseInt(number)] = cur;
			
			if(i < line.length && line[i] == '(') 
			{
				cur = Integer.parseInt(number);
				i++;
			}
			else 
			{
				int count = 0;
				while(i < line.length && line[i] == ')')
				{
					count++;
					i++;
				}
				count--;
				
				while(count--> 0)
					cur = parent[cur];
			}
		}
		
		for(int i = 1; i <= n; i++)
			pw.print(parent[i] + (i == n ? "" : " "));
		
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
