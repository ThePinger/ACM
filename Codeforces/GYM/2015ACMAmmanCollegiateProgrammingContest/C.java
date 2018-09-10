
import java.io.*;
import java.util.*;

public class C 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			
			for(int i = 0; i < n; i++)
			{
				if(s[i] == '*')
				{
					if(i - 1 > -1 && s[i - 1] == '.')
						s[i - 1] = '/';
					if(i + 1 < n && s[i + 1] == '.')
						s[i + 1] = '/';
				}
			}
			
			int count = 0;
			int dots = 0;
			for(int i = 0; i < n; i++)
			{
				if(s[i] == '.')
					dots++;
				else
				{
					if(dots > 0)
						count++;
					dots = 0;
				}
				
				if(dots == 3)
				{
					dots = 0;
					count++;
				}
			}
			
			if(dots > 0)
				count++;
			
			pw.println(count);
		}
		
		pw.flush();
		pw.close();
	}
}