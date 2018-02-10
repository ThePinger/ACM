//MSTICK

import java.io.*;
import java.util.*;

public class Main 
{
    static int rangeS, rangeE, min;
	static int[] arr, segTree, segTreeMax;

    public static void treeSize(int n)
    {
        int size = 1;
        while(size < n) size *= 2;
		segTree = new int[size * 2];
		segTreeMax = new int[size * 2];
    }

	public static void fillSegTreeMax(int node, int lo, int hi)
	{
		if(hi == lo)
        {
            segTreeMax[node] = arr[lo];
            return;
        }

        int mid = (lo + hi) / 2;
        fillSegTreeMax(node * 2, lo, mid);
        fillSegTreeMax((node * 2) + 1, mid + 1, hi);
        segTreeMax[node] = Math.max(segTreeMax[node * 2], segTreeMax[(node * 2) + 1]);
	}

    public static void fillSegTree(int node, int lo, int hi)
    {
        if(hi == lo)
        {
            segTree[node] = arr[lo];
            return;
        }

        int mid = (lo + hi) / 2;
        fillSegTree(node * 2, lo, mid);
        fillSegTree((node * 2) + 1, mid + 1, hi);
        segTree[node] = Math.min(segTree[node * 2], segTree[(node * 2) + 1]);
	}
	
	public static int getMax(int node, int start, int end)
	{
		if(start > rangeE || end < rangeS) return Integer.MIN_VALUE;
        if(start >= rangeS && end <= rangeE) return segTreeMax[node];

        int mid = (start + end) / 2;
        int left = getMax(node * 2, start, mid);
        int right = getMax((node * 2) + 1, mid + 1, end);

        return Math.max(left, right);
	}

    public static int getMin(int node, int start, int end)
    {
        if(start > rangeE || end < rangeS) return Integer.MAX_VALUE;
        if(start >= rangeS && end <= rangeE) return segTree[node];

        int mid = (start + end) / 2;
        int left = getMin(node * 2, start, mid);
        int right = getMin((node * 2) + 1, mid + 1, end);

        return Math.min(left, right);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        treeSize(n);
		fillSegTree(1, 0, n - 1);
		fillSegTreeMax(1, 0, n - 1);

        int q = sc.nextInt();
        while(q-->0)
        {
            int left = sc.nextInt();
			int right = sc.nextInt();
			rangeS = left;
			rangeE = right;
			int burntFirst = getMin(1, 0, n - 1);
			int maxInRange = getMax(1, 0, n - 1);
			rangeS = 0;
			rangeE = left - 1;
			int maxLeft    = getMax(1, 0, n - 1);
			rangeS = right + 1;
			rangeE = n - 1;
			int maxRight   = getMax(1, 0, n - 1);

			double one = ((maxInRange - burntFirst) / 2.0);
			double two = maxLeft;
			double thr = maxRight;

			pw.printf("%.1f\n", (burntFirst + Math.max(one, Math.max(two, thr))));
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