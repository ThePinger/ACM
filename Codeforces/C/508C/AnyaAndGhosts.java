import java.util.*;

public class AnyaAndGhosts
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int dur = sc.nextInt();
		int candles = sc.nextInt();
		long count = 0;
		boolean[] vis = new boolean[601];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		loop : while(m-->0)
		{
			int g = sc.nextInt();
			int need = 0;
			while(!pq.isEmpty())
			{
				int tmp = pq.peek();
				if(tmp < g) pq.poll();
				else break;
			}
			
			if(pq.size() >= candles)
				continue;
			else need = candles - pq.size();
			
			for(int i = g - 1; need > 0 && i >= g - dur; i--)
				if(i + dur < g)
				{
					count = -1;
					break;
				}
				else if(!vis[i + 300])
				{
					pq.add(i + dur);
					vis[i + 300] = true;
					count++;
					need--;
				}
			
			if(need > 0) 
			{
				count = -1;
				break loop;
			}
		}
		System.out.println(count);
	}

}