
import java.io.*;
import java.util.*;

public class D
{
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		long t = sc.nextLong();
		
		long sum = 0;
		Queue<Long> queue = new LinkedList<>();
		for(int i = 0; i < n; i++)
		{
			long tmp = sc.nextLong();
			queue.add(tmp);
			sum += tmp;
		}
		
		long bought = 0;
		while(!queue.isEmpty() && t > 0)
		{
			int size = queue.size();
			long trips = t / sum;
			t -= (sum * trips);
			bought += (size * trips);
			long tmp = t;
			while(size-->0)
			{
				long booth = queue.poll();
				if(booth > tmp)
					sum -= booth;
				else
				{
					tmp -= booth;
					queue.add(booth);
				}
			}
		}
		
		pw.println(bought);
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

