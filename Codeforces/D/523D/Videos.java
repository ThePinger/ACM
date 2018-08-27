import java.io.*;
import java.util.*;

public class Videos
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> end = new PriorityQueue<>();
		while(n-->0)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dur = Integer.parseInt(st.nextToken());
			
			while(!end.isEmpty())
			{
				long tmp = end.peek();
				if(tmp < start)
				{
					end.poll();
					k++;
				}
				else break;
			}
			
			if(k > 0)
			{
				k--;
				end.add(1l * start + dur);
				pw.println(1l * start + dur);
			}
			else
			{
				long x = end.poll();
				end.add(x + dur);
				pw.println(x + dur);
			}
		}
		
		pw.flush();
		pw.close();
	}
}