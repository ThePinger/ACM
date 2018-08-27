import java.io.*;
import java.util.*;

public class MagicalArray
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cons = 0;
		int last = Integer.MAX_VALUE;
		long ans = 0;
		for(int i = 0; i < n; i++)
		{
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == last || last == Integer.MAX_VALUE)
				cons++;
			else
			{
				ans += (1l * cons * (cons + 1)) / 2;
				cons = 1;
			}
			last = tmp;

		}
		ans += (1l * cons * (cons + 1)) / 2;

		
		System.out.println(ans);
	}

}