//52C
//CircularRMQ

import java.util.*;
import java.io.*;

public class CircularRMQ
{

    static int rangeS, rangeE, value;
    static long[] arr, segTree, lazy;

    public static void treeSize(int n)
    {
        int size = 1;
        while(size < n) size *= 2;
        segTree = new long[size * 2];
        lazy    = new long[size * 2];
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

    public static long minValue(int node, int start, int end)
    {
        if(start > rangeE || end < rangeS) return Long.MAX_VALUE;
        if(start >= rangeS && end <= rangeE) return segTree[node];

        int mid = (start + end) / 2;
        propagate(node);
        long left = minValue(node * 2, start, mid);
        long right = minValue((node * 2) + 1, mid + 1, end);

        return Math.min(left, right);
    }

    public static void propagate(int node)
    {
        lazy[node * 2] += lazy[node];
        lazy[(node * 2) + 1] += lazy[node];
        segTree[node * 2] += lazy[node]; 
        segTree[(node * 2) + 1] += lazy[node]; 
        lazy[node] = 0;
    }

    public static void update(int node, int start, int end)
    {
        if(start > rangeE || end < rangeS) return;
        if(start >= rangeS && end <= rangeE)
        {
            segTree[node] += value;
            lazy[node] += value;
            return;
        }

        propagate(node);
        int mid = (start + end) / 2;
        update(node * 2, start, mid);
        update((node * 2) + 1, mid + 1, end);
        segTree[node] = Math.min(segTree[node * 2], segTree[(node * 2) + 1]);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        arr = new long[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        rangeS = 0;
        rangeE = n - 1;
        treeSize(n);
        fillSegTree(1, 0, n - 1);
        int queries = sc.nextInt();

        while(queries-->0)
        {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(st.hasMoreTokens())
            {
                value = Integer.parseInt(st.nextToken());
                if(l > r)
                {
                    rangeS = l;
                    rangeE = n - 1;
                    update(1, 0, n - 1);
                    rangeS = 0;
                    rangeE = r;
                    update(1, 0, n - 1);
                }
                else
                {
                    rangeS = l;
                    rangeE = r;
                    update(1, 0, n - 1);
                }
            }
            else
            {
                if(l > r)
                {
                    rangeS = l;
                    rangeE = n - 1;
                    long min1 = minValue(1, 0, n - 1);
                    rangeS = 0;
                    rangeE = r;
                    long min2 = minValue(1, 0, n - 1);
                    pw.println(Math.min(min1, min2));
                }
                else 
                {
                    rangeS = l;
                    rangeE = r;
                    pw.println(minValue(1, 0, n - 1));
                }
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