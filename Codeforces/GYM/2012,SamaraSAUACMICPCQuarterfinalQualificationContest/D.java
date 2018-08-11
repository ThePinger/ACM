
import java.io.*;
import java.util.*;

public class D 
{
	
	static int[] memo;
	static ArrayList<Integer> divisors;
	
	public static int dp(int n)
	{
		if(n == 1) return 1;
		if(memo[n] != -1) return memo[n];
		
		int ways = 0;
		for(int i = 0; i < divisors.size(); i++)
		{
			int cur = divisors.get(i);
			if(cur != 1 && n % cur == 0)
				ways += dp(n / cur);
		}
		
		return memo[n] = ways;
	}
	
	public static void getDivisors(int x)
	{
		divisors = new ArrayList<>();
		for(int i = 1; 1l * i * i <= x; i++)
		{
			if(x % i == 0)
			{
				divisors.add(i);
				if(x / i != i)
					divisors.add(x / i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		getDivisors(n);
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		pw.println(dp(n));
		pw.flush();
		pw.close();
	}

}
