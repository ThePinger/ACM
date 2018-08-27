import java.io.*;
import java.util.*;

public class PashaAndTea
{
	
	static final double EPS = 1e-6;
	
	public static boolean isOK(double x, double y, int n, int w)
	{
		return (x * n) + (y * n) <= w;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < 2 * n; i++)
			pq.add(Integer.parseInt(st.nextToken()));
		
		int min = pq.poll();
		for(int i = 1; i < n; i++)
			pq.poll();
		int max = pq.poll();
		
		double lo = 0;
		double hi = min;
		double ans = 0;
		for(int i = 0; i < 10000; i++)
		{
			double mid = (lo + hi) / 2;
			if(mid * 2 <= max && isOK(mid, mid * 2, n, w))
			{
				ans = (mid * n) + (mid * 2 * n);
				lo = mid;
			}
			else hi = mid;
		}
		
		System.out.println(ans);
	}
}