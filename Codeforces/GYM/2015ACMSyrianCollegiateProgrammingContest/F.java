import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class F 
{

	static boolean flag;
	
	public static void bf(int idx, int a, int b, int c, int d, int e)
	{
		if(idx == 6) flag = true;
		else if(idx == 1)
		{
			if(a > 0) bf(idx + 1, a - 1, b, c, d, e);
		}
		else if(idx == 2)
		{
			if(b > 0) bf(idx + 1, a, b - 1, c, d, e);
			if(a > 1) bf(idx + 1, a - 2, b, c, d, e);
		}
		else if(idx == 3)
		{
			if(c > 0) bf(idx + 1, a, b, c - 1, d, e);
			if(a > 0 && b > 0) bf(idx + 1, a - 1, b - 1, c, d, e);
		}
		else if(idx == 4)
		{
			if(d > 0) bf(idx + 1, a, b, c, d - 1, e);
			if(b > 1) bf(idx + 1, a, b - 2, c, d, e);
			if(a > 0 && c > 0) bf(idx + 1, a - 1, b, c - 1, d, e);
		}
		else
		{
			if(e > 0) bf(idx + 1, a, b, c, d, e - 1);
			if(a > 0 && d > 0) bf(idx + 1, a - 1, b, c, d - 1, e);
			if(b > 0 && c > 0) bf(idx + 1, a, b - 1, c - 1, d, e);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String s = br.readLine();
			int[] freq = new int[5];
			for(int i = 0; i < s.length(); i++)
				freq[s.charAt(i) - 'A']++;
			
			flag = false;
			bf(1, freq[0], freq[1], freq[2], freq[3], freq[4]);
			
			pw.println(flag ? "YES" : "NO");
		}
		
		pw.flush();
		pw.close();
	}

}
