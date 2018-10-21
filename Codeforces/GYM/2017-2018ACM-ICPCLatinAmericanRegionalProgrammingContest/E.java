import java.io.PrintWriter;
import java.util.Scanner;

public class E 
{
	
	static int n;
	static int[] pow;
	static char[] s;
	static Boolean[][][] memo;
	static PrintWriter pw = new PrintWriter(System.out);
	
	
	public static int modPow(int a, int e, int mod)
	{
		a %= mod;
		int res = 1;
		while(e > 0)
		{
			if((e & 1) == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			e >>= 1;
		}
		return res;
	}
	
	public static boolean dp(int idx, int mod, int pre)
	{
		if(idx == s.length) 
			return mod == 0;
		
		if(memo[idx][mod][pre] != null)
			return memo[idx][mod][pre];
		
		boolean result = false;
		int cur = pow[idx];
		if(s[idx] == '?')
		{
			if(idx != 0)
				result |= dp(idx + 1, (mod + 0 * cur) % n, 0);
			for(int i = 1; i < 10; i++)
				result |= dp(idx + 1, (mod + i * cur) % n, i);
		}
		else result |= dp(idx + 1, (mod + Character.getNumericValue(s[idx]) * cur) % n, Character.getNumericValue(s[idx]));

		return memo[idx][mod][pre] = result;
	}	
	
	public static void trace(int idx, int mod, int pre)
	{
		if(idx == s.length)
		{
			pw.println();
			return;
		}
		
		int cur = pow[idx];
		if(s[idx] == '?')
		{
			if(idx != 0 && dp(idx + 1, (mod + 0 * cur) % n, 0))
			{
				pw.print(0);
				trace(idx + 1, (mod + 0 * cur) % n, 0);
			}
			else 
			{
				for(int i = 1; i < 10; i++)
				{
					if(dp(idx + 1, (mod + i * cur) % n, i))
					{
						pw.print(i);
						trace(idx + 1, (mod + i * cur) % n, i);
						return;
					}
				}
			}
		}
		else 
		{
			pw.print(s[idx]);
			trace(idx + 1, (mod + Character.getNumericValue(s[idx]) * modPow(10, s.length - idx - 1, n)) % n, Character.getNumericValue(s[idx]));
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		s = sc.next().toCharArray();
		n = sc.nextInt();
		
		memo = new Boolean[s.length][n][10];
		
		pow = new int[s.length];
		for(int i = 0; i < s.length; i++)
			pow[i] = modPow(10, s.length - i - 1, n);
		
		if(dp(0, 0, 0))
			trace(0, 0, 0);
		else
			pw.println('*');
		
		pw.flush();
		pw.close();
	}
}
