import java.io.*;
import java.util.*;

public class E 
{
	
	static boolean[] visited;
	static Stack<Integer> stack;
	static ArrayList<Integer>[] adjList;

	public static void topoSort(int cur)
	{
		visited[cur] = true;
		for(int nxt : adjList[cur])
			if(!visited[nxt])
				topoSort(nxt);
		stack.push(cur);
	}
	
	public static void dfs(int cur)
	{
		visited[cur] = true;
		for(int nxt : adjList[cur])
			if(!visited[nxt])
				dfs(nxt);
	}

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int capital = sc.nextInt() - 1;
		
		stack = new Stack<>();
		visited = new boolean[n];
		adjList = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++)
			adjList[sc.nextInt() - 1].add(sc.nextInt() - 1);
		
		dfs(capital);
		boolean[] reach = visited.clone();
		visited = new boolean[n];
		for(int i  = 0; i < n; i++)
			if(!visited[i])
				topoSort(i);
		
		int count = 0;
		visited = new boolean[n];
		while(!stack.isEmpty())
		{
			int cur = stack.pop();
			if(!visited[cur] && !reach[cur])
			{
				adjList[capital].add(cur);
				dfs(capital);
				count++;
			}
		}
		
		System.out.println(count);
		
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
