import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M 
{
	
	static int idx;
	static int[] level, firstApperance;
	static long[] fromRoot, toRoot;
	static boolean[] vis;
	static ArrayList<Integer> eulerWalk;
	static ArrayList<Pair>[] adjList;
	
	public static void dfs(int cur, long from, long to)
	{		
		fromRoot[cur] = from;
		toRoot[cur] = to;
		vis[cur] = true;
		
		eulerWalk.add(cur);
		if(firstApperance[cur] == -1)
			firstApperance[cur] = idx;
		idx++;
		
		for(Pair nxt : adjList[cur])
		{
			if(!vis[nxt.b])
			{
				level[nxt.b] = level[cur] + 1;
				dfs(nxt.b, from + nxt.cost1, to + nxt.cost2);
				eulerWalk.add(cur);
				idx++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[n];
			for(int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();
			
			long total = 0;
			for(int i = 0; i < n - 1; i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int c1 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				adjList[a].add(new Pair(b, c1, c2));
				adjList[b].add(new Pair(a, c2, c1));
				total += c1 + c2;
			}
			
			idx = 0;
			vis = new boolean[n];
			level = new int[n];
			firstApperance = new int[n];
			Arrays.fill(firstApperance, -1);
			toRoot = new long[n];
			fromRoot = new long[n];
			eulerWalk = new ArrayList<>();
			dfs(0, 0, 0);
			
			SegmentTree segmentTree = new SegmentTree();
			
			int q = Integer.parseInt(br.readLine());
			while(q-->0)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int lca = segmentTree.query(1, 0, eulerWalk.size() - 1, Math.min(firstApperance[a], firstApperance[b]), Math.max(firstApperance[a], firstApperance[b]));
				long ans = fromRoot[a] - fromRoot[lca] + toRoot[b] - toRoot[lca];
				pw.println(total - ans);
			}
		}
		pw.flush();
		pw.close();
	}
	
	static class Pair 
	{
		int b, cost1, cost2;
		
		public Pair(int b, int cost1, int cost2)
		{
			this.b = b;
			this.cost1 = cost1;
			this.cost2 = cost2;
		}
	}
	
	static class SegmentTree
	{
	    int[] segTree, lazy;

	    public SegmentTree()
	    {
	    	int n = 1;
	        while(n < eulerWalk.size()) n <<= 1;
	        n <<= 1;
	        
	        this.lazy = new int[n];
	        this.segTree = new int[n];
	        this.build(1, 0, eulerWalk.size() - 1);
	    }

	    public void build(int node, int start, int end)
	    {
	        if(start == end)
	        {
	            this.segTree[node] = eulerWalk.get(start);
	            return;
	        }

	        int mid = (start + end) / 2;
	        build(node << 1, start, mid);
	        build(node << 1 | 1, mid + 1, end);
	        if(level[this.segTree[node << 1]] < level[this.segTree[node << 1 | 1]])
	        	this.segTree[node] = this.segTree[node << 1];
	        else 
	        	this.segTree[node] = this.segTree[node << 1 | 1];
	    }

	    public int query(int node, int start, int end, int l, int r)
	    {
	        if(start > r || end < l) return Integer.MAX_VALUE;
	        if(start >= l && end <= r) return this.segTree[node];

	        int mid = (start + end) / 2;
	        int q1 = query(node << 1, start, mid, l, r);
	        int q2 = query(node << 1 | 1, mid + 1, end, l, r);
	        if(q1 == Integer.MAX_VALUE && q2 == Integer.MAX_VALUE)
	        	return q1;
	        if(q1 == Integer.MAX_VALUE)
	        	return q2;
	        if(q2 == Integer.MAX_VALUE)
	        	return q1;
	        if(level[q1] < level[q2])
	        	return q1;
	        return q2;
	    }

	}
}
