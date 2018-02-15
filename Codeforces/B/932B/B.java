
import java.util.*;
import java.io.*;

public class B
{

    static int[] memo;

    public static int f(int n)
    {
        String s = n + "";
        int sum = 1;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == '0')
                continue;
            else 
                sum *= Character.getNumericValue(s.charAt(i));
        return sum;
    }

    public static int g(int n)
    {
        if(n < 10) return n;
        if(memo[n] != -1) return memo[n];
        return memo[n] = g(f(n));
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        memo = new int[1000001];
        Arrays.fill(memo, -1);
        for(int i = memo.length - 1; i > 0; i--)
            memo[i] = g(i);
            
        int[][] ans = new int[10][1000001];
        for(int i = 1; i < 10; i++)
            for(int j = 1; j < 1000001; j++)
                if(memo[j] == i)
                    ans[i][j] += 1 + ans[i][j - 1];
                else 
                    ans[i][j] += ans[i][j - 1];

        int n = sc.nextInt();
        while(n-->0)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int v = sc.nextInt();
            pw.println(ans[v][r] - ans[v][l - 1]);
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