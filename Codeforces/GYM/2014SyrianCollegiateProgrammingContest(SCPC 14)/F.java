import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		for(int c = 1; c <= t; c++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());
			
			long lo = 0;
			long hi = n;
			long ans = 0;
			while(lo <= hi)
			{
				long mid = (lo + hi) / 2;
				long sum = (mid * (mid + 1)) / 2;
				if(m <= sum)
				{
					ans = mid;
					hi = mid - 1;
				}
				else lo = mid + 1;
			}
			
			ans--;
			long before = (ans * (ans + 1)) / 2;
			m -= before;
			
			pw.println("Case " + c + ": " + ans + " " + (m - 1));
		}
		
		pw.flush();
		pw.close();
	}
}