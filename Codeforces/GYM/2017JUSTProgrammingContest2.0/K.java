
import java.util.*;

public class K 
{
	
	static int[][] memo, grid;
	static ArrayList<Pair> pos;
	static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
	
	public static boolean isValid(int i, int j, int num)
	{
		return i > -1 && i < 3 && j > -1 && j < 3 && grid[i][j] == num;
	}
	
	public static int dp(int idx, int msk)
	{
		if(Integer.bitCount(msk) == 9)
		{	
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(grid[i][j] == 9) continue;
					boolean ans = false;
					for(int c = 0; c < 8; c++)
						ans |= isValid(i + dx[c], j + dy[c], grid[i][j] + 1);
					if(!ans) return 0;
				}
			}	
			return 1;
		}
		
		int ways = 0;
		for(int i = 1; i < 10; i++)
		{
			if(((1 << i) & msk) == 0)
			{
				Pair p = pos.get(idx);
				grid[p.i][p.j] = i;
				ways += dp(idx + 1, (1 << i) | msk);
				grid[p.i][p.j] = 0;
			}
		}
		
		return ways;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		char[][] s = new char[3][3];
		s[0] = sc.next().toCharArray();
		s[1] = sc.next().toCharArray();
		s[2] = sc.next().toCharArray();
		
		grid = new int[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				grid[i][j] = Character.getNumericValue(s[i][j]);
		
		int msk = 0;
		pos = new ArrayList<>();
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if(grid[i][j] == 0)
					pos.add(new Pair(i, j));
				else msk |= 1 << grid[i][j];
	
		System.out.println(dp(0, msk));
	}

	static class Pair
	{
		int i, j;
		
		public Pair(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
}
