import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class J {

	static int[] visited;
	static Stack<Integer> topoSort;
	static ArrayList<Integer>[] adjList;
	
	public static boolean cycleCheck(int cur)
	{
		visited[cur] = 1;
		boolean ans = false;
		for(int nxt : adjList[cur])
		{
			if(visited[nxt] == 0)
				ans |= cycleCheck(nxt);
			else if(visited[nxt] == 1)
				ans = true;
		}
		visited[cur] = 2;
		return ans;
	}
	
	 public static void dfsTopoSort(int cur)
	    {
	        visited[cur] = 1;
	        for(int nxt : adjList[cur])
	            if(visited[nxt] == 0)
	                dfsTopoSort(nxt);
	        topoSort.push(cur);
	    }
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		adjList = new ArrayList[5];
		for(int i = 0; i < 5; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < 5; i++)
		{
			char[] inp = sc.nextLine().toCharArray();
			int a = inp[0] - 'A';
			int b = inp[2] - 'A';
			if(inp[1] == '<')
				adjList[a].add(b);
			else
				adjList[b].add(a);
		}
		
		boolean cycle = false;
		for(int i = 0; i < 5; i++)
		{
			visited = new int[5];
			cycle |= cycleCheck(i);
		}
		
		if(cycle) pw.println("impossible");
		else
		{
			visited = new int[5];
			topoSort = new Stack<>();
			for(int i = 0; i < 5; i++)
				if(visited[i] == 0)
					dfsTopoSort(i);
			
			while(!topoSort.isEmpty())
				pw.print((char)(topoSort.pop() + 'A'));
			pw.println();
		}
		
		
		pw.flush();
		pw.close();
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
