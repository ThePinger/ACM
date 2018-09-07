
import java.io.*;
import java.util.*;

public class D
{
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
        
        int n = sc.nextInt();
        PriorityQueue<Integer> pos = new PriorityQueue<>();
        PriorityQueue<Integer> neg = new PriorityQueue<>();

        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            if(tmp < 1)
                neg.add(tmp);
            else pos.add(tmp);
        }

        long ans = 0;
        if(n == 1)
        {
            if(pos.isEmpty())
                ans = neg.poll();
            else ans = pos.poll();
        }
        else if(pos.isEmpty())
        {
            while(neg.size() > 1)
                ans += Math.abs(neg.poll());
            ans += neg.poll();
        }
        else if(neg.isEmpty())
        {
            ans -= pos.poll();
            while(!pos.isEmpty())
                ans += pos.poll();
        }
        else
        {
            while(!neg.isEmpty())
                ans += Math.abs(neg.poll());

            while(!pos.isEmpty())
                ans += pos.poll();
        }

		pw.println(ans);
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

