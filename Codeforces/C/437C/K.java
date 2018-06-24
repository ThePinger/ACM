//The Child and Toy
import java.util.*;

public class K 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		int[] energy = new int[n];
		ArrayList<Integer>[] adjList = new ArrayList[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i = 0; i < m; i++)
		{
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			energy[a] += arr[b];
			energy[b] += arr[a];
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		for(int i = 0; i < n; i++)
		{
			Node node = new Node(i, energy[i], arr[i]);
			pq.add(node);
		}
		
		int min = 0;
		boolean[] removed = new boolean[n];
		while(!pq.isEmpty())
		{
			Node cur = pq.poll();
			if(removed[cur.num])
				continue;
			min += cur.cost;
			removed[cur.num] = true;
			for(int nxt : adjList[cur.num])
			{
				if(!removed[nxt])
				{
					energy[nxt] -= arr[cur.num];
					pq.add(new Node(nxt, energy[nxt], arr[nxt]));
				}
			}
		}
		
		System.out.println(min);
	}
	
	static class Node implements Comparable<Node>
	{
		int num, cost, energy;
		
		public Node(int num, int cost, int energy)
		{
			this.num = num;
			this.cost = cost;
			this.energy = energy;
		}
		
		public int compareTo(Node n)
		{
			if(this.energy != n.energy)
				return n.energy - this.energy;
			return this.cost - n.cost;
		}
		
		public String toString()
		{
			return this.num + " "  + this.cost;
		}
		
	}

}