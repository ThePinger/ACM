
import java.util.*;

public class H 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int neg = 0;
		for(int i = 0; i < n; i++)
		{
			int num = sc.nextInt();
			pq.add(num);
		}
		
		while(k-->0)
			pq.add(pq.poll() * -1);
		
		long sum = 0;
		while(!pq.isEmpty())
			sum += pq.poll();
		
		System.out.println(sum);
	}

}
