import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class I {

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		char[][] line = new char[3][10];
		line[0] = sc.nextLine().toCharArray();
		line[1] = sc.nextLine().toCharArray();
		line[2] = sc.nextLine().toCharArray();
		
		int lane = 0;
		int start = 0;
		for(int i = 0; i < 10; i++)
		{
			if(line[0][i] == '=')
			{
				lane = 0;
				start = i + 1;
				break;
			}
			
			if(line[1][i] == '=')
			{
				lane = 1;
				start = i + 1;
				break;
			}
			
			if(line[2][i] == '=')
			{
				lane = 2;
				start = i + 1;
				break;
			}
		}
		
		char obs = ' ';
		for(int i = start; i < 10; i++)
		{
			if(line[lane][i] != '.')
			{
				obs = line[lane][i];
				break;
			}
		}
		
		pw.println(obs == ' ' ? "You shall pass!!!" : obs);
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
