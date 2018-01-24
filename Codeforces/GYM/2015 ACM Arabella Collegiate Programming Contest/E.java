
import java.util.*;
import java.io.*;

public class E
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();

        while(n-->0)
        {
            int[] nums = new int[sc.nextInt()];
            for(int i = 0; i < nums.length; i++)
                nums[i] = sc.nextInt();   

            Arrays.sort(nums);
            int total = 0;

            for(int i = 0; i < nums.length; i++)
            {
                int pairs = 0;
                int lo = i + 1;
                int hi = nums.length - 1;
                while(lo <= hi)
                {
                    int mid = (lo + hi) / 2;
                    if(nums[mid] - nums[i] < 32)
                    {
                        pairs = mid - i; 
                        lo = mid + 1;                        
                    }
                    else
                        hi = mid - 1;
                }
                total += pairs;
            }

            pw.println(total);
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