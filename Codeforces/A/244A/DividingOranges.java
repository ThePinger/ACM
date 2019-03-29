//244A
//DividingOranges

import java.util.*;

public class DividingOranges
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[k];
		boolean[] taken = new boolean[n * k + 1];
		
		for(int i = 0; i < k; i++)
		{
			arr[i] = sc.nextInt();
			taken[arr[i]] = true;
		}
		
		for(int i = 0, j = 1; i < k; i++)
		{
			int count = 1;
			System.out.print(arr[i]);
			while(count < n)
			{
				if(!taken[j])
				{
					System.out.print(" " + j);
					count++;
				}
				j++;
			}
			System.out.println();
		}
	}
}