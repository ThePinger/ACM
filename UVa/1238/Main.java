//1238
//Free Parentheses

import java.io.*;
import java.util.*;

public class Main
{

    static int n, count;
    static int[] arr;
    static char[] sign;
    static boolean[] taken;
    static boolean[][][] memo;

    public static void dp(int idx, int sum, int open)
    {
        if(idx == n)
        {
            if(!taken[sum + 3000])
            {
                taken[sum + 3000] = true;
                count++;
            }
            return;
        }

        if(memo[idx][sum + 3000][open])
            return;

        int mul = 1;
        if(open % 2 != 0) mul = -1;

        if(sign[idx] == '-')
        {
            dp(idx + 1, sum + (- arr[idx] * mul), open);
            dp(idx + 1, sum + (- arr[idx] * mul), open + 1);
            if(open > 0)
                dp(idx + 1, sum + (- arr[idx] * mul), open - 1);
        }
        else
        {
            dp(idx + 1, sum + (arr[idx] * mul), open);
            if(open > 0)
                dp(idx + 1, sum + (arr[idx] * mul), open - 1);
        }

        memo[idx][sum + 3000][open] = true;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.ready())
        {

            String[] line = sc.nextLine().split(" ");

            n = (line.length / 2) + 1;
            arr = new int[n];
            sign = new char[n];

            int j = 1;
            sign[0] = '+';
            arr[0] = Integer.parseInt(line[0]);
            for(int i = 1; i < line.length - 1; i += 2)
            {
                sign[j] = line[i].charAt(0);
                arr[j] = Integer.parseInt(line[i + 1]);
                j++;
            }

            count = 0;
            memo = new boolean[n][6001][n];
            taken = new boolean[6001];
            dp(0, 0, 0);
            pw.println(count);
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