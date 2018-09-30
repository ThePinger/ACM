import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class D 
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		for(int a = 1; a <= t; a++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(br.readLine());
			
			Arrays.sort(arr);
			
			long min = 1l * n * d;
			for(int i = 0; i < n; i++)
				min = Math.min(min, (1l * (i + 1) * c * arr[i]) + (1l * (n - i - 1) * d));
			
			pw.println("Case " + a + ": " + min);
		}
		
		pw.flush();
		pw.close();
	}

}
