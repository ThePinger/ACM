//L
import java.io.*;
import java.util.*;

public class L
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n + 1; i++)
			arr[i] = Long.parseLong(st.nextToken());
		
		for(int i = 1; i < n + 1; i++)
		{
			pw.print(arr[i] - arr[i - 1]);
			if(i == n) pw.println();
			else pw.print(" ");
		}
		
		pw.flush();
		pw.close();
	}
	
}

