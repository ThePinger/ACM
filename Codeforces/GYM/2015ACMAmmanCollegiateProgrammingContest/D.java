import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class D 
{
	
	static int n, k;
	static char[] s;
	static int[][][] memo;
	static final int INF = (int) 1e7;
	
	public static int dp(int idx, int alt, int siz)
	{
		if(idx == n)
		{
			if(alt == 1)
				return siz - 1;
			return 0;
		}
		
		if(memo[idx][alt][siz] != -1)
			return memo[idx][alt][siz];
		
		int cut = INF, not = INF;
		if(s[idx] == s[idx - 1])
		{
			if(siz == k)
				cut = (alt == 1 ? k : 1) + dp(idx + 1, 1, 1);
			else
			{
				cut = (alt == 1 ? siz : 1) + dp(idx + 1, 1, 1);
				not = dp(idx + 1, 0, siz + 1);
			}
		}
		else
		{
			if(siz == k)
				cut = (alt == 1 ? k : 1) + dp(idx + 1, 1, 1);
			else
			{
				cut = (alt == 1 ? siz : 1) + dp(idx + 1, 1, 1);
				not = dp(idx + 1, alt, siz + 1);
			}
		}
		
		return memo[idx][alt][siz] = Math.min(cut, not);
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while(t-->0)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			s = sc.next().toCharArray();
			
			memo = new int[n][2][k + 1];
			for(int[][] xx : memo)
				for(int[] x : xx)
					Arrays.fill(x, -1);
				
			pw.println(dp(1, 1, 1));
		}
		pw.close();
	}
}
