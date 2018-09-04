import java.io.*;
import java.util.*;

public class C 
{
	
	static int n, m;
	static long[][] memo;
	static final int mod = 1000000007;
	
	public static long dp(int idx, int cnt)
	{
		if(cnt == n) return 1;
		if(idx > m) return 0;
		if(memo[idx][cnt] != -1)
			return memo[idx][cnt];
		
		long ways = dp(idx + 1, cnt + 1) + dp(idx + 1, cnt);
		return memo[idx][cnt] = ways % mod;
	}
	
	
	public static void main(String args[]) throws IOException
	{	
		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));	
//		Scanner sc = new Scanner(System.in);
//		PrintWriter pw = new PrintWriter(System.out);
				
		n = sc.nextInt();
		m = sc.nextInt();
		
		memo = new long[m + 1][n];
		for(long[] x : memo)
			Arrays.fill(x, -1);
		
//		for(int i = 1; i <= m; i++)
//			ans = (ans + dp(i + 1, 1)) % mod;
		
		pw.println(dp(1, 0));
		pw.flush();
		pw.close();
	}
}
