import java.io.*;
import java.util.*;

public class CaseOfMatryoshka
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long sec = 0;
		int rem = 0;
		while(m-->0)
		{
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()) - 1;
			int pre = 0;
			if(st.nextToken().equals("1"))
				pre = 1;
			else rem++;
			
			while(c-->0)
			{
				int tmp = Integer.parseInt(st.nextToken());
				if(pre != 0 && pre + 1 == tmp)
					pre++;
				else 
				{
					sec++;
					rem++;
				}
			}
		}
		
		System.out.println(sec + rem);
	}

}