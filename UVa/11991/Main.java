//11991
//Easy Problem from Rujia Liu?

import java.io.*;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.StringTokenizer;;


public class Main
{
    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.ready())
        {
            int n = sc.nextInt();
            int q = sc.nextInt();
            ArrayList<Integer>[] adjList = new ArrayList[1000001];
            for(int i = 0; i < adjList.length; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < n; i++)
                adjList[sc.nextInt() - 1].add(i + 1);

            while(q-->0)
            {
                int occur = sc.nextInt();
                int num   = sc.nextInt() - 1;

                if(adjList[num].size() < occur) pw.println(0);
                else pw.println(adjList[num].get(occur - 1));
            }
        }

        pw.flush();
        pw.close();
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
