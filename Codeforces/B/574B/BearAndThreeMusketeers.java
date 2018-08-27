import java.io.*;
import java.util.*;

public class BearAndThreeMusketeers
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer>[] adjList = new TreeSet[n];
		for(int i = 0; i < n; i++)
			adjList[i] = new TreeSet<>();
		
		while(m-->0)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			adjList[x].add(y); adjList[y].add(x);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++)
			for(int nxt : adjList[i])
				for(int nxtNxt : adjList[nxt])
					if(adjList[nxtNxt].contains(i))
						min = Math.min(min, adjList[i].size() - 2 + adjList[nxt].size() - 2 + adjList[nxtNxt].size() - 2);
		
		
		pw.println(min == Integer.MAX_VALUE ? -1 : min);
		pw.flush();
		pw.close();
	}

}