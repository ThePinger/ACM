
import java.io.*;
import java.util.*;


public class C 
{
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		long[] arr = new long[n];
		long[] tmp = new long[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextLong();
		
		for(int i = 0; i < n; i++)
			tmp[i] = sc.nextLong();
    
    long cumm = 0;
    for(int i = 0; i < n; i++)
    {
      arr[i] += cumm;
      cumm += tmp[i];
    }

		PriorityQueue<Long> pq = new PriorityQueue<>();
		long lazy = 0;
		for(int i = 0; i < n; i++)
		{
			long ans = 0;
			lazy += tmp[i];
			pq.add(arr[i]);
			while(!pq.isEmpty() && pq.peek() < lazy)
				ans += pq.poll() - (lazy - tmp[i]);
			
			ans += pq.size() * tmp[i]; 
			sb.append(ans + " ");
		}
		System.out.println(sb);
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
