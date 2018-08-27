import java.util.*;

public class YaroslavAndSequence
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int neg = 0;
		PriorityQueue<Integer> pos = new PriorityQueue<>();
		int sum = 0;
		for(int i = 0; i < 2 * n - 1; i++)
		{
			int tmp = sc.nextInt();
			if(tmp < 0) neg++;
			pos.add(Math.abs(tmp));
		}
		
		if(neg % 2 != 0 && n % 2 == 0)
			sum -= pos.poll();

		
		while(!pos.isEmpty())
			sum += pos.poll();
		
		System.out.println(sum);
	}
}