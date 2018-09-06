//1040A
//PalindromeDance 

import java.io.*;
import java.util.*;

public class A
{
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int bl = sc.nextInt();
		int ans = 0;
		boolean flag = true;
		Queue<Integer> first = new LinkedList<>();
		Stack<Integer> last = new Stack<>();
		if(n % 2 == 0)
		{
			for(int i = 0; i < n / 2; i++)
				first.add(sc.nextInt());
			
			for(int i = 0; i < n / 2; i++)
				last.add(sc.nextInt());
			
			while(!last.isEmpty())
			{
				int a = first.poll();
				int b = last.pop();
				
				if(a == 2 && b == 2)
					ans += 2 * Math.min(w, bl);
				else if(a == 2)
				{
					if(b == 0)
						ans += w;
					else ans += bl;
				}
				else if(b == 2)
				{
					if(a == 0)
						ans += w;
					else ans += bl;
				}
				else if(a != b) flag = false;
			}
		}
		else
		{
			for(int i = 0; i < n / 2; i++)
				first.add(sc.nextInt());
			
			int mid = sc.nextInt();
			if(mid == 2)
				ans += Math.min(w, bl);
			
			for(int i = 0; i < n / 2; i++)
				last.add(sc.nextInt());
			
			while(!last.isEmpty())
			{
				int a = first.poll();
				int b = last.pop();
				
				if(a == 2 && b == 2)
					ans += 2 * Math.min(w, bl);
				else if(a == 2)
				{
					if(b == 0)
						ans += w;
					else ans += bl;
				}
				else if(b == 2)
				{
					if(a == 0)
						ans += w;
					else ans += bl;
				}
				else if(a != b) flag = false;
			}
		}
		
		pw.println(flag ? ans : -1);
		
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

