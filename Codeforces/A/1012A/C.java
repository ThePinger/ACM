//1012A
//Photo of The Sky

import java.io.*;
import java.util.*;

public class C
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int[] arr = new int[2 * n];
		for(int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		
        Arrays.sort(arr);
    
        int x1 = arr[0];
        int y1 = arr[n];
        int x2 = arr[n - 1];
        int y2 = arr[arr.length - 1];
        
        long ans = 1l * (x2 - x1) * (y2 - y1);		
        for(int i = 1; i + n - 1 < arr.length - 1; i++)
            ans = Math.min(ans, 1l * (arr[i + n - 1] - arr[i]) * (y2 - x1));
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
