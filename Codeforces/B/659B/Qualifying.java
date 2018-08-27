import java.io.*;
import java.util.*;

public class Qualifying
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Pair>[] pq = new PriorityQueue[m + 1];
		for(int i = 0; i < pq.length; i++)
			pq[i] = new PriorityQueue<>();
		
		while(n-->0)
		{
			st = new StringTokenizer(br.readLine());
			String nam = st.nextToken();
			int reg = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			pq[reg].add(new Pair(score, nam));
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= m; i++)
		{
			Pair top = pq[i].poll();
			Pair sec = pq[i].poll();
			boolean again = false;
			if(!pq[i].isEmpty())
			{
				Pair tmp = pq[i].poll();
				if(tmp.val == sec.val)
					again = true;
			}
			
			if(again) pw.println("?");
			else
				pw.println(top.name + " " + sec.name);
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Pair implements Comparable<Pair>
	{
		int val;
		String name;
		
		public Pair(int val, String name)
		{
			this.val = val;
			this.name = name;
		}
		
		public int compareTo(Pair p)
		{
			return p.val - this.val;
		}
	}
}