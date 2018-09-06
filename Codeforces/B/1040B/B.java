//1040B
//ShashilkCooking

import java.io.*;
import java.util.*;

public class B
{
	
	
	static int n, k;
	static int[][] memo;
	static PrintWriter pw;
	
	public static int dp(int cur, int pre)
	{
		if(cur > n)
		{
			if(cur - pre > n)
				return 0;
			return (int) 1e7;
		}
		
		if(memo[cur][pre] != -1) return memo[cur][pre];
		
		int take = (int) 1e7, leave = (int) 1e7;
		if(pre == k)
			take = 1 + dp(cur + k + 1, 0);
		else 
		{
			if(cur - k < 1)
				take = 1 + dp(cur + k + 1, 0);
			leave = dp(cur + 1, pre + 1);
		}
		
		return memo[cur][pre] = Math.min(take, leave);
	}
	
	public static void trace(int cur, int pre)
	{
		if(cur > n)
			return;
		
		int take = (int) 1e7, leave = (int) 1e7;
		if(pre == k)
			take = 1 + dp(cur + k + 1, 0);
		else
		{
			if(cur - k < 1)
				take = 1 + dp(cur + k + 1, 0);
			leave = dp(cur + 1, pre + 1);
		}
		
		if(memo[cur][pre] == take)
		{
			pw.print(cur + " ");
			trace(cur + k + 1, 0);
		}
		else
			trace(cur + 1, pre + 1);
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		n = sc.nextInt();
		k = sc.nextInt();
		
		memo = new int[n + 1][k + 1];
		for(int[] x : memo)
			Arrays.fill(x, -1);
		
		pw.println(dp(1, 0));
		trace(1, 0);
		pw.println();
		
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

