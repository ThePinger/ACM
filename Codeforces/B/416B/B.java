
import java.io.*;
import java.util.*;

public class B 
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] time = new int[m][n];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				time[i][j] = sc.nextInt();
		
		int[][] finish = new int[m][n];
		finish[0][0] = time[0][0];
		for(int i = 1; i < m; i++)
			finish[i][0] = time[i][0] + finish[i - 1][0];
		
		for(int i = 0; i < m; i++)
			for(int j = 1; j < n; j++)
				if(i == 0)
					finish[i][j] = time[i][j] + finish[i][j - 1];
				else
					finish[i][j] = time[i][j] + Math.max(finish[i][j -1], finish[i - 1][j]);
		
		for(int i = 0; i < m; i++)
			pw.print(finish[i][n - 1] + " ");
		
		pw.flush();
		pw.close();
	}
}
