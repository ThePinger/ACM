//920F
//SUM and REPLACE

import java.util.*;
import java.io.*;

public class SumReplace
{

    static int rangeS, rangeE;
	static long[] arr, segTree, divisors, segTreeMax;

    public static void treeSize(int n)
    {
        int size = 1;
        while(size < n) size <<= 1;
		segTree = new long[size << 1];
		segTreeMax = new long[size << 1];
	}

    public static void buildTree(int node, int lo, int hi)
    {
        if(lo == hi)
        {
			segTree[node] = arr[lo];
			segTreeMax[node] = arr[lo];
            return;
        }

        int mid = (lo + hi) / 2;
        buildTree(node * 2, lo, mid);
        buildTree((node * 2) + 1, mid + 1, hi);
		segTree[node] = segTree[node * 2] + segTree[(node * 2) + 1];
		segTreeMax[node] = Math.max(segTreeMax[node * 2], segTreeMax[(node * 2) + 1]);
	}
	
	public static void update(int node, int lo, int hi)
	{
		if(segTreeMax[node] < 3 || lo > rangeE || hi < rangeS) return;
		if(lo == hi)
		{
			segTree[node] = divisors[(int)segTree[node]];
			segTreeMax[node] = divisors[(int)segTreeMax[node]];
			return;
		}

		int mid = (lo + hi) / 2;
        update(node * 2, lo, mid);
        update((node * 2) + 1, mid + 1, hi);
		segTree[node] = segTree[node * 2] + segTree[(node * 2) + 1];	
		segTreeMax[node] = Math.max(segTreeMax[node * 2], segTreeMax[(node * 2) + 1]);		
	}

    public static long sumQuery(int node, int lo, int hi)
    {
        if(lo > rangeE || hi < rangeS) return 0;
        if(lo >= rangeS && hi <= rangeE) return segTree[node];
		
		int mid = (lo + hi) / 2;
		long right = sumQuery(node * 2, lo, mid);
		long left  = sumQuery((node * 2) + 1, mid + 1, hi);
		return right + left;
        
    }

    public static void main(String[] args) throws IOException
    {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int q = sc.nextInt();
        arr = new long[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        divisors = new long[1000001];
		for(int i = 1; i < 1000001; i++) 
			for(int j = i; j < 1000001; j += i)
				divisors[j]++;

        treeSize(n);
        buildTree(1, 0, n - 1);

        while(q-->0)
        {
			if(sc.nextInt() == 1)
			{
				rangeS = sc.nextInt() - 1;
				rangeE = sc.nextInt() - 1;
				update(1, 0, n - 1);
			}
			else
			{
				rangeS = sc.nextInt() - 1;
				rangeE = sc.nextInt() - 1;
				pw.println(sumQuery(1, 0, n - 1));
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