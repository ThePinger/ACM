//1017B
//The Bits

import java.io.*;
import java.util.*;

public class B
{
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		int zero0 = 0;
		int zero1 = 0;
		int one0 = 0;
		int one1 = 0;
		
		for(int i = 0; i < a.length; i++)
			if(a[i] == '0' && b[i] == '1')
				zero1++;
			else if(a[i] == '0' && b[i] == '0')
				zero0++;
			else if(a[i] == '1' && b[i] == '0')
				one0++;
			else if(a[i] == '1' && b[i] == '1')
				one1++;
		
		long ans = 0;
		long tmp = 1l * zero1 * one0;
		ans += tmp;
		tmp = 1l * zero0 * one0;
		ans += tmp;
		tmp = 1l * zero0 * one1;
		ans += tmp;
		
		pw.println(ans);
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

