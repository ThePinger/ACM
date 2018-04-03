import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B 
{
	static int min;
	static int numSets;
	static int[] p, rank, setSize, cost;
	
	public static int findSet(int i) 
	{
		return p[i] == i ? i : (p[i] = findSet(p[i])); 
	}

	public static boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	public static void unionSet(int i, int j) 
	{ 
		if (isSameSet(i, j)) 
			return;
		numSets--; 
		int x = findSet(i), y = findSet(j);
		if(rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; cost[x] = Math.min(cost[x], cost[y]); }
		else
		{	p[x] = y; setSize[y] += setSize[x];
			if(rank[x] == rank[y]) rank[y]++; 
			cost[y] = Math.min(cost[x], cost[y]);
		} 
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> map = new TreeMap<>();
		int n = sc.nextInt();
		int groups = sc.nextInt();
		int words = sc.nextInt();
		p = new int[n + 1];
		rank = new int[n + 1];
		setSize = new int[n + 1];
		cost = new int[n + 1];
		
		for(int i = 1; i < n + 1; i++)
			p[i] = i;
		
		String[] line = new String[n + 1];
		for(int i = 1; i < n + 1; i++)
		{
			String tmp = sc.next();
			map.put(tmp, i);
			line[i] = tmp;
		}
		
		for(int i = 1; i < n + 1; i++)
			cost[i] = sc.nextInt();
		
		for(int i = 0; i < groups; i++)
		{
			int num = sc.nextInt() - 1;
			int head = sc.nextInt();
			while(num-->0)
				unionSet(head, sc.nextInt());
		}
		String[] msg = new String[words];
		for(int i = 0; i < words; i++)
			msg[i] = sc.next();
		
 		long ans = 0;
		for(int i = 0; i < msg.length; i++)
			ans += cost[findSet(map.get(msg[i]))];
		System.out.println(ans);
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
