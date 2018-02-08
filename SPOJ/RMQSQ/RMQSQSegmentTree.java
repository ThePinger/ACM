//RMQSQ
//Segment Tree

import java.util.*;
import java.awt.Point;
import java.io.*;

public class RMQSQSegmentTree
{

    static int rangeS, rangeE;
    static int[] arr, segTree;

    public static void treeSize(int n)
    {
        int size = 1;
        while(size < n) size *= 2;
        segTree = new int[size * 2];
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

    public static int minValue(int node, int start, int end)
    {
        if(start > rangeE || end < rangeS) return -1;
        if(start == rangeS && end == rangeE) return segTree[node];
        if(start == end) return segTree[node];

        int mid = (start + end) / 2;
        int left = minValue(node * 2, start, mid);
        int right = minValue((node * 2) + 1, mid + 1, end);

        if(left == -1) return right;
        if(right == -1) return left;

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
        int q = sc.nextInt();

        while(q-->0)
        {
            rangeS = sc.nextInt();
            rangeE = sc.nextInt();
            pw.println(minValue(1, 0, n - 1));
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