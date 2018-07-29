//585A
//Gennady the Dentist

import java.io.*;
import java.util.*;

public class C
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		Triple[] arr = new Triple[n];
		for(int i = 0; i < n; i++)
			arr[i] = new Triple(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		Queue<Integer> ans = new LinkedList<>();
		for(int i = 0; i < n; i++)
		{
			Triple tmp = arr[i];
			if(tmp.p < 0) continue; 
			ans.add(i + 1);
			long rem = tmp.v;
			for(int j = i + 1; j < n; j++)
			{
				if(arr[j].p >= 0)
					arr[j].p -= rem;	
				else continue;
				
				if(arr[j].p < 0)
					rem += arr[j].d;
				if(tmp.v > 0)
				{
					rem--;
					tmp.v--;
				}
			}
		}
		
		pw.println(ans.size());
		while(!ans.isEmpty())
			pw.print(ans.poll() + " ");
		pw.println();
		
		pw.flush();
		pw.close();
	}

	static class Triple
	{
		long v, d, p;
		
		public Triple(long v, long d, long p)
		{
			this.v = v;
			this.d = d;
			this.p = p;
		}
		public String toString()
		{
			return v + " " + d + " " + p;
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
