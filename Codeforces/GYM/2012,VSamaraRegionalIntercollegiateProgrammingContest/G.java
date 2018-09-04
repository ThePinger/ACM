
import java.io.*;
import java.util.*;

public class G 
{
	public static void main(String[] args) throws IOException
	{
//		Scanner sc = new Scanner(System.in);
//		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
			pq.add(new Pair(i, sc.nextInt()));
		
		int[] ans = new int[n];
		while(k > 0 && !pq.isEmpty())
		{
			Pair p = pq.poll();
			ans[p.idx] = Math.min(k, p.val);
			k -= ans[p.idx];
		}
		
		for(int i = 0; i < n; i++)
			if(i + 1 == n)
				pw.println(ans[i]);
			else pw.print(ans[i] + " ");
		
		pw.flush();
		pw.close();
	}
	
	static class Pair implements Comparable<Pair>
	{
		int idx, val;
		
		public Pair(int idx, int val)
		{
			this.idx = idx;
			this.val = val;
		}
		
		public int compareTo(Pair p)
		{
			return this.val - p.val;
		}
	}
}
