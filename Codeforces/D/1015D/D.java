//1015D
//Walking Between Houses

import java.io.*;
import java.util.*;

public class D
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long s = sc.nextLong();
		
		long dist = (s / k);
		long mod = s % k;
		if((mod > 0 && dist + 1 > n - 1) || dist > n - 1 || s < k) pw.println("NO");
		else
		{
			pw.println("YES");
			long cur = 1;
			boolean flag = true;
			while(k-->0)
			{
				long tmp = dist;
				if(mod-->0)
					tmp++;
				
				if(flag) cur = cur + tmp;
				else cur = cur - tmp;
				pw.print(cur + " ");
				flag = !flag;
			}
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
