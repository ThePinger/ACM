//Prison Transfer
import java.util.*;

public class E 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++)
			if(arr[i] > t)
				list.add(i);
		
		list.add(n);
		
		int j = 0;
		int ways = 0;
		for(int i = 0; i < list.size(); i++)
		{
			int cur = list.get(i);
			if(cur - j >= c)
			{
				ways++;
				i--;
				j++;
			}
			else
				j = cur + 1;
		}
		
		System.out.println(ways);
	}

}
