import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class M 
{
	
	static int n;
	static int[] memo, nxt, arr;
	
	public static int dp(int idx)
	{
		if(idx == n) return 0;
		if(memo[idx] != -1) return memo[idx];
		
		int min = 1 + dp(idx + 1);
		if(nxt[idx] > idx)
			min = Math.min(min, 1 + dp(nxt[idx]));
		
		return memo[idx] = min;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		n = Integer.parseInt(br.readLine());
		nxt = new int[n];
		int[] pre = new int[200001];
		Arrays.fill(pre, -1);
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
		{
			int cur = Integer.parseInt(st.nextToken());
			if(pre[cur] != -1) nxt[pre[cur]] = i;
			pre[cur] = i;
			arr[i] = cur;
		}
				
		memo = new int[n];
		Arrays.fill(memo, -1);
		
		pw.println(dp(0) - 1);
		
		pw.flush();
		pw.close();
	}
}
