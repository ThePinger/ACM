
import java.io.*;
import java.util.*;

public class H 
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> ans = new Stack<>();
		int[] last = new int[51];
		Arrays.fill(last, -1);
		
		for(int i = n - 1; i > -1; i--)
		{
			int near = -1;
			int num = -1;
			for(int j = arr[i] + 1; j < 51; j++)
				if(last[j] > -1 && (near == -1 || last[j] < near))
				{
					near = last[j];
					num = j;
				}
			ans.add(num);
			last[arr[i]] = i;
		}
		
		while(!ans.isEmpty())
			if(ans.size() == 1)
				pw.println(ans.pop());
			else pw.print(ans.pop() + " ");
		
		pw.flush();
		pw.close();
	}

}
