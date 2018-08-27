import java.io.*;
import java.util.*;

public class DrazilFriends 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		boolean[] boy = new boolean[n];
		boolean[] girl = new boolean[m];
				
		int boys = sc.nextInt();
		for(int i = 0; i < boys; i++)
			boy[sc.nextInt()] = true;
		
		int girls = sc.nextInt();
		for(int i = 0; i < girls; i++)
			girl[sc.nextInt()] = true;
		
		int day = 0;
		while(day < 1000000)
		{
			int i = day % n;
			int j = day % m;
			
			
			if(boy[i] || girl[j])
				boy[i] = girl[j] = true; 
			day++;
		}
		
		boolean all = true;
		for(int i = 0; i < n; i++)
			all &= boy[i];
		
		for(int i = 0; i < m; i++)
			all &= girl[i];
		
		System.out.println(all ? "Yes" : "No");
	}
}