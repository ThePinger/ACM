
import java.io.*;
import java.util.*;

public class D 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		while(n-->0)
		{
			char[] s = br.readLine().toCharArray();
			int sym = 0;
			int dig = 0;
			int let = 0;
			for(int i = 0; i < s.length; i++)
			{
				if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z'))
					let++;
				else if(s[i] >= '0' && s[i] <= '9')
					dig++;
				else sym++;
			}
			
			if(let > 3 && dig > 3 && sym > 1)
				pw.println("The last character can be any type.");
			else if(let < 4)
				pw.println("The last character must be a letter.");
			else if(dig < 4)
				pw.println("The last character must be a digit.");
			else
				pw.println("The last character must be a symbol.");
		}
		
		pw.flush();
		pw.close();
	}
}
