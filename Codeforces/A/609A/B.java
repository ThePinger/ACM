//USB Flash Drives
import java.util.*;

public class B 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int file = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		while(n-->0)
			pq.add(sc.nextInt());
		
		int count = 0;
		while(!pq.isEmpty() && file > 0)
		{
			file -= pq.poll();
			count++;
		}
		
		System.out.println(count);
	}
}
