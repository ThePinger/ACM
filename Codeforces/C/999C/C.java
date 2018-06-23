import java.io.*;
import java.util.*;

public class C
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		char[] s = sc.next().toCharArray();
		int[] freq = new int[26];
		PriorityQueue<Character> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++)
		{
			pq.add(s[i]);
			freq[s[i] - 'a']++;
		}
		int[] freqx2 = freq.clone();
		
		while(k-->0)
		{
			char cur = pq.poll();
			freq[cur - 'a']--;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			if(freq[s[i] - 'a'] == freqx2[s[i] - 'a'] && freq[s[i] - 'a'] != 0)
				sb.append(s[i]);
			else if(freqx2[s[i] - 'a'] > 0)
				freqx2[s[i] - 'a']--;
		}
		
		System.out.println(sb);
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
