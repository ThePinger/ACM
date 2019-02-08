
import java.io.*;
import java.util.*;

public class B
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int x = arr[n - 1];
		int notDiv = 0;
		int y = 0;
		
		for(int i = 0; i < n; i++)
			if(x % arr[i] != 0)
				notDiv = arr[i];
		
		if(notDiv == 0) 
		{ 
			for(int i = n - 1; i > 0; i--)
			{
				if(arr[i] == arr[i - 1])
				{
					y = arr[i];
					break;
				}
			}
		}
		else
		{
			for(int i = n - 1; i > -1; i--)
			{
				if(arr[i] % notDiv == 0)
				{
					y = arr[i];
					break;
				}
			}
		}
		
		System.out.println(x + " " + y);
		
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
