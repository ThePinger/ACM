
import java.io.*;
import java.util.*;

public class C 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		long[][] adjMat = new long[n][n];
		long[][] grid = new long[n][n];
		
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
			{
				adjMat[i][j] = Integer.parseInt(st.nextToken());
				grid[i][j] = adjMat[i][j];
			}
		}
		
		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
	
		boolean flag = true;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(adjMat[i][j] != grid[i][j])
					flag = false;
		
		if(flag)
		{
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					pw.print(grid[i][j]);
					if(j + 1 < n) pw.print(" ");
				}
				pw.println();
			}
		}
		else pw.println(-1);
		
		pw.flush();
		pw.close();
	}
}
