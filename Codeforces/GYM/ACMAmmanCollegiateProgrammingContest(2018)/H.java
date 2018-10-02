import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class H 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[2 * n + 1];
			for(int i = 1; st.hasMoreTokens(); i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for(int i = 1; i < arr.length; i++)
				max = Math.max(max, arr[i] + arr[2 * n - i + 1]);
			
			pw.println(max);
		}
		
		pw.flush();
		pw.close();
	}
}
