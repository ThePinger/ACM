//893C
//Rumor

import java.io.*;
import java.util.*;

public class C
{

	static boolean[] visited;
	static ArrayList<Integer>[] adjMat;
	
	public static void dfs(int cur)
	{
		visited[cur] = true;
		for(int nxt : adjMat[cur])
			if(!visited[nxt])
				dfs(nxt);
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int m = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
			pq.add(new Pair(i, sc.nextInt()));
		
		adjMat = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adjMat[i] = new ArrayList<>();
		
		while(m-->0)
		{
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			adjMat[a].add(b);
			adjMat[b].add(a);
		}
		
		long cost = 0;
		visited = new boolean[n];
		for(int i = 0; i < n; i++)
		{
			Pair p = pq.poll();
			if(!visited[p.x])
			{
				dfs(p.x);
				cost += p.cost;
			}
		}
		
		pw.println(cost);
		pw.flush();
		pw.close();
	}
	
	static class Pair implements Comparable<Pair>
	{
		int x, cost;
		
		public Pair(int x, int cost)
		{
			this.x = x;
			this.cost = cost;
		}
		
		public int compareTo(Pair p)
		{
			return this.cost - p.cost;
		}
	}
	
	static class Scanner 
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException 
        {
            while (st == null || !st.hasMoreTokens()) 
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}
        
        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}
        
        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }
        
        public boolean ready() throws IOException {return br.ready();}

    }
}
