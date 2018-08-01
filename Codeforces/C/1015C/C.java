//1015C
//Songs Compression

import java.io.*;
import java.util.*;

public class C 
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int size = sc.nextInt();
		long total = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			total += a;
			pq.add(new Pair(a, b));
		}
		
		if(size >= total) pw.println(0);
		else
		{
			int count = 0;
			while(!pq.isEmpty() && size < total)
			{
				count++;
				Pair p = pq.poll();
				total -= p.a; total += p.b;
			}
			pw.println(size < total ? -1 : count);
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Pair implements Comparable<Pair>
	{
		int a, b;
		
		public Pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
		
		public int compareTo(Pair p)
		{
			int save1 = this.a - this.b;
			int save2 = p.a - p.b;
			return save2 - save1;
		}
		
		public String toString()
		{
			return a + " " + b;
		}
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
