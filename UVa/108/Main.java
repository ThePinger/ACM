//108
//Maximum Sum

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cumSum = new int[n][n];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
            {
                if(i - 1 > -1 && j - 1 > -1)
                    cumSum[i][j] = sc.nextInt() + cumSum[i - 1][j] + cumSum[i][j - 1] - cumSum[i - 1][j - 1];
                else if(i - 1 > -1)
                    cumSum[i][j] = sc.nextInt() + cumSum[i - 1][j];
                else if(j - 1 > -1)
                    cumSum[i][j] = sc.nextInt() + cumSum[i][j - 1];
                else
                    cumSum[i][j] = sc.nextInt();
            }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int ii = i; ii < n; ii++)
                    for(int jj = j; jj < n; jj++)
                        if(i - 1 > -1 && j - 1 > -1)
                            max = Math.max(max, cumSum[ii][jj] - cumSum[i - 1][jj] - cumSum[ii][j - 1] + cumSum[i - 1][j - 1]);
                        else if(i - 1 > -1)
                            max = Math.max(max, cumSum[ii][jj] - cumSum[i - 1][jj]);
                        else if(j - 1 > -1)
                            max = Math.max(max, cumSum[ii][jj] - cumSum[ii][j - 1]);
                        else 
                            max = Math.max(max, cumSum[ii][jj]);

        System.out.println(max);
    }

    static class Scanner
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s)
		{
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String s) throws FileNotFoundException
		{
			br = new BufferedReader(new FileReader(new File((s))));
		}

		public String next() throws IOException
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException
		{
			return br.readLine();
		}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else
				{
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException
		{
			return br.ready();
        }
    }
}
