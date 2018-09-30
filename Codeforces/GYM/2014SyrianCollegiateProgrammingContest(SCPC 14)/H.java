import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;




public class H {
	
	static int n ,m , grid[][];
	static int[][] memo;
	
	public static int dp(int x, int y)
	{
		if(x == n - 1 && y == m - 1)
			return grid[x][y];
		
		if(memo[x][y] != Integer.MIN_VALUE)
			return memo[x][y];
		
		int max;
		if(x == n - 1)
			max = grid[x][y] + dp(x, y + 1);
		else if(y == m - 1)
			max = grid[x][y] + dp(x + 1, y);
		else
			max = Math.max(grid[x][y] + dp(x + 1, y), grid[x][y] + dp(x, y + 1));
		
		return memo[x][y] = max;
	}
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		int c=1;
		while(t-->0)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());;
			grid=new int[n][m];
			for(int i=0;i<n;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++)
					grid[i][j] = Integer.parseInt(st.nextToken());
			}
			
			memo = new int[n][m];
			for(int[] x : memo)
				Arrays.fill(x, Integer.MIN_VALUE);
			
			pw.println("Case "+c+": "+dp(0, 0));
			c++;
		}
		pw.close();
	}
	
//	static int dik()
//	{
//		int dx[]= {1,0};
//		int dy[]= {0,1};
//		int dist[][]=new int[n][m];
//		for(int i=0;i<n;i++)
//			Arrays.fill(dist[i], -(int)1e9);
//		dist[0][0]=grid[0][0];
//		PriorityQueue<Edge>pq=new PriorityQueue<>();
//		pq.add(new Edge(0, 0, grid[0][0]));
//		while(!pq.isEmpty())
//		{
//			Edge cur=pq.poll();
//			if(cur.c<dist[cur.i][cur.j])continue;
//			for(int i=0;i<2;i++)
//			{
//				int x=cur.i+dx[i];int y=cur.j+dy[i];
//				if(valid(x,y))
//				{	
//					Edge nxt=new Edge(x, y, cur.c+grid[x][y]);
//					if(nxt.c>dist[x][y])
//					{
//						dist[cur.i+dx[i]][cur.j+dy[i]]=nxt.c;
//						pq.add(nxt);
//					}
//				}
//			}
//		}
//		return dist[n-1][m-1];
//	}
//	static boolean valid(int x,int y)
//	{
//		return x<n && y<m;
//	}
//	static class Edge implements Comparable<Edge>
//	{
//		int i,j,c;
//		public Edge(int ii,int jj,int cc) {
//			// TODO Auto-generated constructor stub
//			i=ii;j=jj;c=cc;
//		}
//		@Override
//		public int compareTo(Edge o) {
//			// TODO Auto-generated method stub
//			return o.c-c;
//		}
//	}
}
