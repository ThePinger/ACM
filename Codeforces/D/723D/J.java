
import java.util.*;

public class J 
{
	
	static int row, col;
	static char[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static PriorityQueue<Lake> lakes;
	
	public static boolean isValid(int i, int j)
	{
		return i > -1 && j > -1 && i < row && j < col;
	}
	
	public static int dfs(int i, int j)
	{
		if(grid[i][j] != '.')
			return 0;
		
		int ans = 1;
		grid[i][j] = 'L';
		for(int c = 0; c < 4; c++)
		{
			int x = i + dx[c];
			int y = j + dy[c];
			if(isValid(x, y))
				ans += dfs(x, y);
		}
		
		return ans;
	}
	
	public static void markOceans(int i, int j)
	{
		if(grid[i][j] != '.')
			return;
		
		grid[i][j] = 'O';
		for(int c = 0; c < 4; c++)
		{
			int x = i + dx[c];
			int y = j + dy[c];
			if(isValid(x, y))
				markOceans(x, y);
		}
	}
	
	public static void fillLakes(int i, int j)
	{
		if(grid[i][j] != 'L')
			return;
		
		grid[i][j] = '*';
		for(int c = 0; c < 4; c++)
		{
			int x = i + dx[c];
			int y = j + dy[c];
			if(isValid(x, y))
				fillLakes(x, y);
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		int maxLakes = sc.nextInt();
		grid = new char[row][col];
		lakes = new PriorityQueue<>();
		
		for(int i = 0; i < row; i++)
			grid[i] = sc.next().toCharArray();
		
		for(int i = 0; i < row; i++)
			if(grid[i][0] == '.')
				markOceans(i, 0);
		
		for(int i = 0; i < row; i++)
			if(grid[i][col - 1] == '.')
				markOceans(i, col - 1);
		
		for(int i = 0; i < col; i++)
			if(grid[0][i] == '.')
				markOceans(0, i);
		
		for(int i = 0; i < col; i++)
			if(grid[row - 1][i] == '.')
				markOceans(row - 1, i);
		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(grid[i][j] == '.')
				{
					int ans = dfs(i, j);
					lakes.add(new Lake(i, j, ans));
				}
			}
		}
		
		int count = 0;
		while(lakes.size() > maxLakes)
		{
			Lake l = lakes.poll();
			count += l.count;
			fillLakes(l.x, l.y);
		}
		
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				if(grid[i][j] == 'L' || grid[i][j] == 'O')
					grid[i][j] = '.';
		
		System.out.println(count);
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
				System.out.print(grid[i][j]);
			System.out.println();
		}
	}
	
	static class Lake implements Comparable<Lake>
	{
		int x, y, count;
		
		public Lake(int x, int y, int count)
		{
			this.x = x;
			this.y = y;
			this.count = count;
		}
		
		public int compareTo(Lake l)
		{
			return this.count - l.count;
		}
	}

}
