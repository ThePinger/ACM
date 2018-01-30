//793
//Network Connections

import java.io.*;
import java.util.*;

public class Main 
{
    static int[] parent, rank;

    public static void initializeSets(int size)
    {
        parent = new int[size + 1];
        rank   = new int[size + 1];

        for(int i = 0; i < size + 1; i++) 
            parent[i] = i;
    }

    public static int findSet(int i)
    {
        if(parent[i] == i) return i;
        return findSet(parent[i]);
    }

    public static boolean isSameSet(int i, int j)
    {
        return findSet(i) == findSet(j);
    }

    public static void union(int i, int j)
    {
        int ii = findSet(i);
        int jj = findSet(j);
        if(ii == jj) return;

        if(rank[ii] > rank[jj])
            parent[jj] = ii;
        else
        {
            parent[ii] = jj;
            if(rank[ii] == rank[jj]) rank[jj]++;
        }
    }

    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            initializeSets(sc.nextInt());
            int yes = 0;
            int no  = 0;

            while(true)
            {
                String s = sc.nextLine();
                if(s == null || s.length() == 0) break;

                StringTokenizer st = new StringTokenizer(s);
                if(st.nextToken().equals("c"))
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                else
                    if(isSameSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))
                        yes++;
                    else
                        no++;
            }
            pw.println(yes + "," + no);
            if(t > 0) pw.println();
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
