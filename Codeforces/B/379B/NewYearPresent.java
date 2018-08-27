import java.io.*;
import java.util.*;

public class NewYearPresent
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			int tmp = Integer.parseInt(st.nextToken());
			while(tmp-->0)
			{
				if(i + 1 == n)
				{
					sb.append('L');
					sb.append('R');
				}
				else
				{
					sb.append('R');
					sb.append('L');
				}
				sb.append('P');
			}
			if(i + 1 != n)
				sb.append('R');
		}
		
		System.out.println(sb);
	}
}