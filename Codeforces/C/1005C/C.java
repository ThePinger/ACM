//1005C
//Summarize to the Power of Two

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class C 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int[] arr = new int[n];
		TreeMap<Integer, Integer> set = new TreeMap<>();
		for(int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
			if(set.containsKey(arr[i]))
				set.put(arr[i], set.get(arr[i]) + 1);
			else 
				set.put(arr[i], 1);
		}
		

		int[] powers = new int[33];
		for(int i = 0; i < 33; i++)
			powers[i] = 1 << i;

		int count = 0;
		loop: for(int i = 0; i < n; i++)
		{
			int cur = arr[i];
			for(int j = 0; j < 31; j++)
			{
				if(set.containsKey(powers[j] - cur) && (set.get(powers[j] - cur) > 1 || powers[j] - cur != cur))
					continue loop;
			}
			count++;
		}
		
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
