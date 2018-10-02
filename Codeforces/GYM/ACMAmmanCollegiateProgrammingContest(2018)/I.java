import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class I 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(n > x) pw.println(-1);
			else
			{
				int add = x / n;
				int mod = x % n;
				
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				while(n-->0)
				{
					if(mod-->0) pq.add(add + 1);
					else pq.add(add);
				}
				
				while(!pq.isEmpty())
					pw.print(pq.size() == 1 ? pq.poll() : pq.poll() + " ");
				pw.println();
			}
		}
		
		pw.flush();
		pw.close();
	}
	
}
