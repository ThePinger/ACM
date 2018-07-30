//1013B
//And

import java.io.*;
import java.util.*;

public class B 
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int and = sc.nextInt();
		int[] arr = new int[n];
		int[] freq = new int[100001];
		boolean[] found = new boolean[100001];
		
		boolean f = false;
		for(int i = 0; i < n; i++)
		{
			int tmp = sc.nextInt();
			arr[i] = tmp;
			freq[tmp]++;
			if(freq[tmp] > 1) f = true;
		}
		
		if(f) pw.println(0);
		else
		{
			int count = 3;
			for(int i = 0; i < n; i++)
			{
				int tmp = arr[i] & and;
				if(tmp == arr[i]) continue;
				if(freq[tmp] > 0) count = 1;
				else if(found[tmp])
					count = Math.min(count, 2);
				else
					found[tmp] = true;
			}
			
			pw.println(count == 3 ? -1 : count);
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
