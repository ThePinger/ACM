//339D
//Xenia and Bit Operations

import java.util.*;
import java.io.*;

public class XeniaBits
{

    static boolean f;
    static long[] arr, segTree;

    public static void treeSize(int n)
    {
        int size = 1;
        while(size < n) size <<= 1;
        segTree = new long[size << 1];
    }

    public static void build(int node, int lo, int hi)
    {
        if(hi == lo)
        {
            segTree[node] = arr[lo];
            f = true;
            return;
        }

        int mid = (lo + hi) / 2;
        build(node * 2, lo, mid);
        build((node * 2) + 1, mid + 1, hi);
        if(f) segTree[node] = segTree[node * 2] | segTree[(node * 2) + 1];
        else segTree[node] = segTree[node * 2] ^ segTree[(node * 2) + 1];
        f = !f;
    }

    public static void updatePoint(int node, long v)
    {
        node += arr.length - 1;
        segTree[node] = v;
        int i = 1;        
        while(node > 1)
        {
            node >>= 1;
            if(i % 2 != 0) segTree[node] = segTree[node * 2] | segTree[(node * 2) + 1];
            else segTree[node] = segTree[node * 2] ^ segTree[(node * 2) + 1];
            i++;
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = 1 << sc.nextInt();
        int q = sc.nextInt();
        arr = new long[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        treeSize(n);
        build(1, 0, n - 1);

        while(q-->0)
        {
            int idx = sc.nextInt();
            long v   = sc.nextLong();
            updatePoint(idx, v);
            pw.println(segTree[1]);
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