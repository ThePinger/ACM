
import java.io.*;
import java.util.*;

public class J 
{
	
	static int n, t;
	static Cost[] distance;
	static ArrayList<Edge>[] adjList;
	
	public static void dijkstra(int maxSec)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, 0));
		distance = new Cost[n];
		for(int i = 0; i < n; i++)
			distance[i] = new Cost(Long.MAX_VALUE, Long.MAX_VALUE);
		
		while(!pq.isEmpty())
		{
			Edge cur = pq.poll();
			if(cur.cost.compareTo(distance[cur.node]) > 0) continue;
			for(Edge nxt : adjList[cur.node])
            {
				Cost tmp = new Cost(nxt.cost.weight + cur.cost.weight, Math.max(nxt.cost.level, cur.cost.level));
                if(tmp.weight <= t && tmp.compareTo(distance[nxt.node]) < 0 && tmp.level <= maxSec)
                {
                    distance[nxt.node] = tmp;
                    pq.add(new Edge(nxt.node, distance[nxt.node].weight, distance[nxt.node].level));
                }
            }
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		
//		Scanner sc = new Scanner(System.in);
//		PrintWriter pw = new PrintWriter(System.out);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		adjList = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++)
		{
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int t = sc.nextInt();
			int l = sc.nextInt();
			adjList[x].add(new Edge(y, t, l));
			adjList[y].add(new Edge(x, t, l));
		}
		
		t = sc.nextInt();
		int lo = 1;
		int hi = (int) 1e6;
		Cost ans = new Cost(Long.MAX_VALUE, Long.MAX_VALUE);
		while(lo <= hi)
		{
			int mid = (lo + hi) / 2;
			dijkstra(mid);
			if(distance[n - 1].weight <= t)
			{
				hi = mid - 1;
				ans = new Cost(distance[n - 1].weight, distance[n - 1].level);
			}
			else
				lo = mid + 1;
		}
		
		if(ans.weight <= t)
		{
			pw.println("YES");
			pw.println(ans.level + " " + ans.weight);
		}
		else pw.println("NO");
		
		pw.flush();
		pw.close();
	}
	
	static class Edge implements Comparable<Edge>
	{
		int node;
		Cost cost;
		
		public Edge(int node, long weight, long level)
		{
			this.node = node;
			this.cost = new Cost(weight, level);
		}
		
		public int compareTo(Edge e)
		{
			return this.cost.compareTo(e.cost);
		}
	}
	
	static class Cost implements Comparable<Cost>
	{
		long weight, level;
		
		public Cost(long weight, long level)
		{
			this.weight = weight;
			this.level = level;
		}
		
		public int compareTo(Cost c)
		{
			return this.weight == c.weight ? 0 : this.weight > c.weight ? 1 : -1;
		}
	}
}