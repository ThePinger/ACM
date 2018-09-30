import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class J {
	
	static boolean[] vis;
	static ArrayList<Integer>[] adjList;
	
	public static void dfs(int cur)
	{
		vis[cur] = true;
		for(int nxt : adjList[cur])
			if(!vis[nxt])
				dfs(nxt);
	}

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		while(t-->0)
		{
			st=new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[n];
			for(int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();
			
			TreeMap<String, Integer> map = new TreeMap<>();
			String[] idx = new String[n];
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(br.readLine());
				idx[i] = st.nextToken();
				map.put(idx[i], i);
				
				int nxt = Integer.parseInt(st.nextToken());
				while(nxt-->0)
					adjList[i].add(map.get(st.nextToken()));
			}
			
			vis = new boolean[n];
			st = new StringTokenizer(br.readLine());
			while(m-->0)
				dfs(map.get(st.nextToken()));
			
			for(int i = 0; i < n; i++)
				if(vis[i])
					pw.println(idx[i]);
		}
		
		pw.flush();
		pw.close();
	}
}
