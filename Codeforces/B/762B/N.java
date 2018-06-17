
import java.io.*;
import java.util.*;

public class N 
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int usb = Integer.parseInt(st.nextToken());
		int ps2 = Integer.parseInt(st.nextToken());
		int both = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			char t;
			if(st.nextToken().equals("USB"))
				t = 'U';
			else
				t = 'P';
			pq.add(new Pair(p, t));
		}
		
		int taken = 0;
		long price = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			if(p.type == 'U')
			{
				if(usb > 0)
				{
					taken++;
					price += p.price;
					usb--;
				}
				else if(both > 0)
				{
					taken++;
					price += p.price;
					both--;
				}
			}
			else
			{
				if(ps2 > 0)
				{
					taken++;
					price += p.price;
					ps2--;
				}
				else if(both > 0)
				{
					taken++;
					price += p.price;
					both--;
				}
			}
		}
		
		System.out.println(taken + " " + price);
	}

	static class Pair implements Comparable<Pair>
	{
		int price;
		char type;
		
		public Pair(int price, char type)
		{
			this.price = price;
			this.type  = type;
		}
		
		public int compareTo(Pair p)
		{
			return this.price - p.price;
		}
	}
}
