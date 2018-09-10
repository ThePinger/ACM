
import java.io.*;
import java.util.*;

public class F 
{
	
	static int n;
	static UnionFind uf;
	static ArrayList<Edge> edgeList;
	
	public static int mst()
	{
		int min = Integer.MIN_VALUE;
		Collections.sort(edgeList);
		uf = new UnionFind(n);
		
		for(int i = 0; i < edgeList.size(); i++)
		{
			Edge e = edgeList.get(i);
			if(!uf.isSameSet(e.a, e.b))
			{
				min = Math.max(min, e.cost);
				uf.union(e.a, e.b);
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(sc.readLine());
		while(t-->0)
		{
			String s = sc.readLine();
			if(s.equals(""))
				s = sc.readLine();
			StringTokenizer st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			edgeList = new ArrayList<>();
			while(m-->0)
			{
				st = new StringTokenizer(sc.readLine());
				edgeList.add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
			}
			pw.println(mst());
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Edge implements Comparable<Edge>
	{
		int a, b, cost;
		
		public Edge(int a, int b, int cost)
		{
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		public int compareTo(Edge e)
		{
			return this.cost - e.cost;
		}
	}
	
	static class UnionFind
	{
		int[] rank, parent;
		
		public UnionFind(int size)
		{
			this.rank = new int[size];
			this.parent = new int[size];
			for(int i = 0; i < size; i++)
			{
				this.rank[i] = 1;
				this.parent[i] = i;
			}
		}
		
		public int findSet(int i)
		{
			return i == parent[i] ? i : (parent[i] = findSet(parent[i]));
		}
		
		public boolean isSameSet(int i, int j)
		{
			return findSet(i) == findSet(j);
		}
		
		public void union(int i, int j)
		{
			int ii = findSet(i);
			int jj = findSet(j);
			
			if(rank[ii] > rank[jj])
				parent[jj] = ii;
			else 
			{
				parent[ii] = jj;
				if(rank[ii] == rank[jj]) rank[jj]++;
			}
		}
	}
}