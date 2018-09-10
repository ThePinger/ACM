

import java.io.*;
import java.util.*;

public class B 
{
	static int n;
	static char[] s;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(sc.readLine());
		while(t-->0)
		{
			n = Integer.parseInt(sc.readLine());
			s = sc.readLine().toCharArray();
			
			int[] wonR = new int[n + 1];
			int[] wonP = new int[n + 1];
			int[] wonS = new int[n + 1];
			
			for(int i = 0; i < n; i++)
				if(s[i] == 'S')
					wonR[i + 1]++;
				else if(s[i] == 'P')
					wonR[i + 1]--;
			
			for(int i = 0; i < n; i++)
				if(s[i] == 'R')
					wonP[i + 1]++;
				else if(s[i] == 'S')
					wonP[i + 1]--;
			
			for(int i = 0; i < n; i++)
				if(s[i] == 'P')
					wonS[i + 1]++;
				else if(s[i] == 'R')
					wonS[i + 1]--;
			
			for(int i = 1; i <= n; i++)
			{
				wonR[i] += wonR[i - 1];
				wonP[i] += wonP[i - 1];
				wonS[i] += wonS[i - 1];
			}
			
			long ways = 0;
			for(int i = 0; i <= n; i++)
			{
				for(int j = 0; j <= n; j++)
				{
					if(i + j > n) continue;
					int z = n - i - j;
					int score = (wonR[i] - wonR[0]) + (wonP[j + i] - wonP[i]) + (wonS[z + j + i] - wonS[j + i]);
					if(score > 0)
						ways++;
				}
			}
			pw.println(ways);
		}
		
		pw.flush();
		pw.close();
	}
}