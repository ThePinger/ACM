import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class K 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		char[] s = br.readLine().toCharArray();
		int right = 0;
		for(int i = 0; i < s.length; i++)
		{
			if(s[i] == ')')
			{
				if(right == 0)
				{
					right = -1;
					break;
				}
				else right--;
			}
			else right++;
		}
		
		if(right == -1) pw.println("IMPOSSIBLE");
		else
		{
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < s.length; i++)
				sb.append(s[i]);
			while(right-->0) sb.append(')');
			pw.println(sb);
		}
		
		pw.flush();
		pw.close();
	}
}
