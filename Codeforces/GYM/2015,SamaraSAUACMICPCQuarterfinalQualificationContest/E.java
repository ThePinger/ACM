
import java.io.PrintWriter;
import java.util.*;

public class E 
{
	
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 1; i <= n; i++)
			pq.add(new Pair(sc.nextInt(), sc.nextInt(), i));
		
		int res = 1;
		int count = 0;
		StringBuilder sb = new StringBuilder();
		loop : while(!pq.isEmpty())
		{
			int max = -1;
			int idx = -1;
			while(!pq.isEmpty())
			{
				Pair p = pq.peek();
				if(p.cost <= res)
				{
					if(p.res > max)
					{
						max = p.res;
						idx = p.idx;
					}
					
					if(p.idx == n)
					{
						count++;
						sb.append(n);
						pw.println(count);
						pw.println(sb);
						break loop;
					}
					
					pq.poll();
				}
				else break;
			}
			
			if(idx == -1)
			{
				pw.println("No such luck");
				break;
			}
			else
			{
				count++;
				res = max;
				sb.append(idx).append(" ");
			}
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Pair implements Comparable<Pair>
	{
		int cost, res, idx;
		
		public Pair(int cost, int res, int idx)
		{
			this.cost = cost;
			this.res = res;
			this.idx = idx;
		}
		
		public int compareTo(Pair p)
		{
			return this.cost - p.cost;
		}
	}
}