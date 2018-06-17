
import java.util.*;
import java.io.*;

public class G 
{
	
	static int problems;
	static boolean[] visited;
	static ArrayList<Pair>[] adjList;
	static TreeSet<Integer> set;
	
	public static void dfs(int cur, int problem)
	{
		visited[cur] = true;		
		for(Pair nxt : adjList[cur])
		{
			if(!visited[nxt.node])
			{
				if(nxt.problem == 2) problems++;
				dfs(nxt.node, nxt.problem);
			}
		}
		
		if(problem == 2 && problems > 0)
		{
			problems = 0;
			set.add(cur);
		}
		
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n];
		adjList = new ArrayList[n];
		set = new TreeSet<>();
		
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < n - 1; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int p = Integer.parseInt(st.nextToken());
			adjList[a].add(new Pair(b, p));
			adjList[b].add(new Pair(a, p));
		}
		
		dfs(0, 0);
		
		System.out.println(set.size());
		while(!set.isEmpty())
			System.out.print(set.pollFirst() + 1 + " ");
		System.out.println();
	}
	
	static class Pair
	{
		int node, problem;
		
		public Pair(int node, int problem)
		{
			this.node = node;
			this.problem = problem;
		}
	}

}
