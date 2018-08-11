import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class G 
{
		
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		char[] s = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		TreeSet<Character> begin = new TreeSet<>();
		boolean[] vis = new boolean[26];
		for(int i = 0; i < s.length; i++)
			begin.add(s[i]);
		
		boolean flag = true;
		for(int i = 0; i < s.length; i++)
		{
			if(begin.contains(s[i]))
			{
				begin.remove(s[i]);
				vis[s[i] - 'a'] = true;
				sb.append(s[i]);
			}
			else
			{
				char add = '#';
				for(int j = 0; j < 26; j++)
				{
					if(begin.contains((char) (j + 'a')) || vis[j])
						continue;
					add = (char) ('a' + j);
					break;
				}
				
				if(add == '#')
				{
					pw.println("IMPOSSIBLE");
					flag = false;
					break;
				}
				
				vis[add - 'a'] = true;
				sb.append(add);
			}
		}
			
		if(flag)
			pw.println(sb);
		
		
		pw.flush();
		pw.close();
	}
}
