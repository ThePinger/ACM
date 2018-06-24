//Bakery
import java.util.*;

public class D 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int f = sc.nextInt();
		
		ArrayList<Edge>[] adjList = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++)
		{
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			adjList[a].add(new Edge(b, c));
			adjList[b].add(new Edge(a, c));
		}
		
		if(f == 0) System.out.println(-1);
		else
		{
			int min = Integer.MAX_VALUE;
			Queue<Integer> factories = new LinkedList<>();
			boolean[] isFactory = new boolean[n];
			while(f-->0)
			{
				int tmp = sc.nextInt() - 1;
				isFactory[tmp] = true;
				factories.add(tmp);
			}
			
			while(!factories.isEmpty())
			{
				int cur = factories.poll();
				for(Edge nxt : adjList[cur])
					if(!isFactory[nxt.node])
						min = Math.min(min, nxt.cost);
			}
			
			if(min == Integer.MAX_VALUE) 
				System.out.println(-1);
			else
				System.out.println(min);
		}
	}
	
	static class Edge
	{
		int node, cost;
		
		public Edge(int node, int cost)
		{
			this.node = node;
			this.cost = cost;
		}
	}

}
