
import java.util.*;

public class B 
{
	
	static int n;
	static char[] s;
	static int[][] memo;
	static final int MOD = 1000000007;
	
	public static int dp(int idx, int msk)
	{
		if(idx == n) return 1;
		
		if(memo[idx][msk] != -1) return memo[idx][msk];
		
		long ways = 0;
		int cur = Character.getNumericValue(s[idx]);
		if(((1 << cur) & msk) == 0)
		{
			ways += dp(idx + 1, (1 << cur) | msk);
			if(msk != 0)
				ways += dp(idx + 1, 1 << cur);
		}
		else ways += dp(idx + 1, 1 << cur);
		
		return memo[idx][msk] = (int) (ways % MOD);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.next().toCharArray();

		memo = new int[n][1 << 10];
		for(int[] x : memo)
			Arrays.fill(x, -1);

		System.out.println(dp(0, 0));
	}
}
