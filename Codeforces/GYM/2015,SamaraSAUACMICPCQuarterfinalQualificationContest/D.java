import java.util.Scanner;
import java.util.TreeMap;

public class D
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]a = new int[n + 1];
		long[] sum = new long[n + 1];
		
		for(int i = 1; i <= n; i++)
		{
			a[i] = sc.nextInt();
			sum[i] = a[i] + sum[i - 1];
		}
		
		int start = 0;
		int end = 0;
		TreeMap<Long, Integer> map = new TreeMap<>();
		for(int i = 1; i <= n; i++)
		{
			if(map.containsKey(sum[i]))
			{
				int tmp = map.get(sum[i]) + 1;
				if((end - start + 1) > (i - tmp + 1) || start == 0)
				{
					start = tmp;
					end = i;
				}
			}
			else if(sum[i] == 0 && ((end - start + 1) > i || start == 0))
			{
				start = 1;
				end = i;
			}
			map.put(sum[i], i);
		}
		
		System.out.println(start == 0 ? -1 : (start + " " + (end - start + 1)));
	}
}