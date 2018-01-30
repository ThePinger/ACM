//10583
//Ubiquitous Religions

import java.util.*;
import java.io.*;

public class Main
{
    static int sets;
    static int[] parent, rank;

    public static void initializeSets(int size)
    {
        sets = size;
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

        sets--;
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
        int t = 1;

        while(true)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n == 0 && m == 0) break;

            initializeSets(n);
            
            while(m-->0)
                union(sc.nextInt(), sc.nextInt());

            pw.println("Case " + (t++) + ": " + sets);
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