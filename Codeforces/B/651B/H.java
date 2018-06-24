//Beautiful Paintings
import java.util.*;

public class H 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] freq = new int[1001];
		
		for(int i = 0; i < n; i++)
			freq[sc.nextInt()]++;
		
		int count = 0;
		while(n > 0)
		{
			int c = 0;
			boolean first = true;
			for(int i = 0; i < 1001; i++)
			{
				if(freq[i]-->0)
				{
					if(!first)
						count++;
					first = false;
					c++;
				}
			}
			n -= c;
		}
			
		System.out.println(count);
	}

}
