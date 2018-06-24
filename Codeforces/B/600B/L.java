//Queries about less or equal elements
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class L 
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		int[] b = new int[m];
		
		for(int i = 0; i < n; i++)
			a.add(sc.nextInt());
		
		for(int i = 0; i < m; i++)
			b[i] = sc.nextInt();
		
		Collections.shuffle(a);
		Collections.sort(a);
		
		for(int i = 0; i < m; i++)
		{
			int num = -1;
			int lo = 0;
			int hi = n - 1;
			while(lo <= hi)
			{
				int mid = (lo + hi) / 2;
				int cur = a.get(mid);
				if(cur > b[i])
					hi = mid - 1;
				else
				{
					lo = mid + 1;
					num = mid;
				}
			}
			System.out.print(num + 1 + " ");
		}
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
