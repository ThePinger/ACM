//893D
//Credit Card

import java.io.*;
import java.util.*;

public class D
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
		int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long[] maxNxt = new long[n];
        maxNxt[n - 1] = arr[n - 1];
        for(int i = n - 2; i > -1; i--)
            maxNxt[i] = Math.max(maxNxt[i + 1] + arr[i], arr[i]);

        int count = 0;
        long account = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == 0)
            {
                if(account < 0)
                {
                    account = Math.max(0, d - maxNxt[i]);
                    count++;
                }
            }
            else
            {
                if(account + arr[i] > d) 
                {
                    count = -1;
                    break;
                }
                account += arr[i];
            }
        }
		
		pw.println(count);
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

