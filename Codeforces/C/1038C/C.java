
import java.io.*;
import java.util.*;

public class C
{
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++)
			a.add(sc.nextInt());
		
		for(int i = 0; i < n; i++)
			b.add(sc.nextInt());
		
		long aa = 0;
		long bb = 0;
		boolean turn = true;
		while(!a.isEmpty() || !b.isEmpty())
		{
			if(turn)
			{
				if(b.isEmpty())
					aa += a.poll();
				else if(a.isEmpty())
					b.poll();
				else
				{
					int maxa = a.peek();
					int maxb = b.peek();
					if(maxa >= maxb)
						aa += a.poll();
					else
						b.poll();
				}
			}
			else
			{
				if(b.isEmpty())
					a.poll();
				else if(a.isEmpty())
					bb += b.poll();
				else
				{
					int maxa = a.peek();
					int maxb = b.peek();
					if(maxa > maxb)
						a.poll();
					else
						bb += b.poll();
				}
			}
			
			turn = !turn;
		}
		
		pw.println(aa - bb);
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

