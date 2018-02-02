//61D
//Eternal Victory

import java.util.*;
import java.io.*;

public class Victory
{
    static int cities;
    static boolean[] visited;
    static ArrayList<EdgeDistance>[] adjList;

    public static long dfs(int cur)
    { 
        visited[cur] = true;                
        long ans = 0;
        for(EdgeDistance nxt : adjList[cur])
            if(!visited[nxt.b])
                ans = Math.max(ans, nxt.distance + dfs(nxt.b));

        return ans;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        cities = sc.nextInt();    
        adjList = new ArrayList[cities];
        visited = new boolean[cities];

        for(int i = 0; i < cities; i++)
            adjList[i] = new ArrayList<>();

        long sum = 0;
        for(int i = 0; i < cities - 1; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            sum += z * 2;
            adjList[x - 1].add(new EdgeDistance(y - 1, z));
            adjList[y - 1].add(new EdgeDistance(x - 1, z));
        }

        System.out.println(sum - dfs(0));
    }

    static class EdgeDistance
    {
        int  b, distance;

        public EdgeDistance(int b, int distance)
        {
            this.b = b;
            this.distance = distance;
        }
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