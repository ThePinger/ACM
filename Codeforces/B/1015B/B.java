//1015B
//Obtaining the Stirng 

import java.io.*;
import java.util.*;

public class B
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		String s = sc.next();
		String t = sc.next();
		int[] freqS = new int[26];
		int[] freqT = new int[26];
		
		for(int i = 0; i < n; i++)
		{
			freqS[s.charAt(i) - 'a']++;
			freqT[t.charAt(i) - 'a']++;
		}
		
		boolean f = true;
		for(int i = 0; i < 26; i++)
			if(freqS[i] != freqT[i])
				f = false;
		
		if(s.equals(t)) pw.println(0);
		else if(f)
		{
			char[] ss = s.toCharArray();
			char[] tt = t.toCharArray();
			Queue<Integer> moves = new LinkedList<>();
			for(int j = 0; j < n - 1; j++)
			{
				if(ss[j] != tt[j])
				{
					int idx = 0;
					for(int c = j; c < n; c++)
						if(tt[j] == ss[c])
						{
							idx = c;
							break;
						}
						
					for(int c = idx; c > j; c--)
					{
						char tmp = ss[c];
						ss[c] = ss[c - 1];
						ss[c - 1] = tmp;
						moves.add(c);
					}					
				}
			}
			
			pw.println(moves.size());
			while(!moves.isEmpty())
				pw.print(moves.poll() + " ");
		}
		else pw.println(-1);
		
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
