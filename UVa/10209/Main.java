//10209
//Is This Integration ?

import java.io.*;
import java.util.*;

public class Main
{

    public static double square(double x)
    {
        return x * x;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);  

        while(sc.ready())
        {
            double a = sc.nextDouble();
            double c = square(a) * (1 - (Math.PI / 6) - (Math.sqrt(3) / 4));
            double b = square(a) - ((Math.PI * square(a)) / 4) - (2 * c);

            pw.printf("%.3f %.3f %.3f", (square(a) - (4 * b) - (4 * c)), 4 * b, 4 * c);
            pw.println();
        }
        
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