
import java.util.*;
import java.io.*;

public class B
{
    static int[] nums;

    public static int sum(int x)
    {
        String tmp = x + "";
        int sum = 0;
        for(int i = 0; i < tmp.length(); i++)
            sum += Character.getNumericValue(tmp.charAt(i));

        return sum;
    }

    public static void calc()
    {
        nums = new int[10001];
        nums[1] = 19;
        for(int i = 2; i < 10001; i++)
            if(sum(nums[i - 1] + 9) != 10)
            {
                int tmp = nums[i - 1] + 10;
                while(sum(tmp) != 10)
                    tmp++;
                nums[i] = tmp;
            }
            else
                nums[i] = nums[i - 1] + 9;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        calc();
        int n = sc.nextInt();
        System.out.println(nums[n]);
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