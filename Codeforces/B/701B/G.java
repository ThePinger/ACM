//Cells Not Under Attack
import java.util.*;

public class G 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cols = 0;
		int rows = 0;
		boolean[] row = new boolean[n];
		boolean[] col = new boolean[n];
		long notAttacked = 1l *n * n;
		StringBuilder sb = new StringBuilder();
		while(m-->0)
		{
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			if(!row[a])
			{
				
				if(!col[b])
				{
					cols++;
					col[b] = true;
					notAttacked -= n - rows;
				}
				
				notAttacked -= n - cols;
				rows++;
				row[a] = true;
			}
			else if(!col[b])
			{
				cols++;
				col[b] = true;
				notAttacked -= n - rows;
			}
			
			sb.append(notAttacked + " ");
		}
		
		System.out.println(sb);
	}

}
