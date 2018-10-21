import java.util.Arrays;
import java.util.Scanner;

public class G 
{
	
	static int n, m;
	static int[] calories;
	static long[][][] memo; 
	
	public static long dp(int idx, int lastM, int noEating)
	{
		if(idx == n)
			return 0;
		
		if(memo[idx][lastM][noEating] != -1)
			return memo[idx][lastM][noEating];
		
		long take = Integer.MIN_VALUE;
		long leave = Integer.MIN_VALUE;
		
		if(noEating == 0)
		{
			if(lastM > m)
				take = Math.min(m, calories[idx]) + dp(idx + 1, m, 0);
			else 
				take = Math.min((int) Math.floor((lastM * 2.0) / 3.0), calories[idx]) + dp(idx + 1, (int) Math.floor((lastM * 2.0) / 3.0), 0);
			leave = dp(idx + 1, lastM, 1);
		}
		else if(noEating == 1)
		{
			if(lastM > m)
				take = Math.min(m, calories[idx]) + dp(idx + 1, m, 0);
			else
				take = Math.min(lastM, calories[idx]) + dp(idx + 1, lastM, 0);
			leave = dp(idx + 1, lastM, 2);
		}
		else
		{
			take = Math.min(m, calories[idx]) + dp(idx + 1, m, 0);
			leave = dp(idx + 1, lastM, noEating);
		}
		
		return memo[idx][lastM][noEating] = Math.max(take, leave);
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		calories = new int[n];
		for(int i = 0; i < n; i++)
			calories[i] = sc.nextInt();
		
		memo = new long[n][m + 2][3];
		for(long[][] x : memo)
			for(long [] xx : x)
				Arrays.fill(xx, -1);
		
		System.out.println(dp(0, m + 1, 0));
	}
}
