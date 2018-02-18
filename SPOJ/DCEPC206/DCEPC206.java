//DCEPC206

import java.io.*;
import java.util.*;

public class DCEPC206
{
    static int size = 1000001;
    static long[] fenwickTree;

    public static long sumQuery(int i)
    {
        long sum = 0;
        while(i > 0)
        {
            sum += fenwickTree[i];
            i -= i & -i;
        }
        return sum;
    }

    public static void updateTree(int i)
    {
        int v = i;
        while(i < size)
        {
            fenwickTree[i] += v;
            i += i & -i;
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] freq = new int[size];
            fenwickTree = new long[size];
            
            long sum = 0;
            for(int i = 0; i < n; i++)
            {
                arr[i] = sc.nextInt();
                freq[arr[i]]++;
                if(arr[i] != 0) 
                {
                    updateTree(arr[i]);
                    sum += sumQuery(arr[i]) - (arr[i] * freq[arr[i]]);
                }
            }

            pw.println(sum);
        }

        pw.flush();
        pw.close();
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