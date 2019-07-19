import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

	static int min;
	static String finalPath;
	static char[][] grid;
	static char[][] clone;
	static int[] dx = new int[]{0, 0, 1, -1};
	static int[] dy = new int[]{1, -1, 0, 0};
	static char[] direction = new char[]{'R', 'L', 'D', 'U'};
	
	
	public static boolean isValid(int x, int y)
	{
		return x > -1 && x < 12 && y > -1 && y < 12 && clone[x][y] != '#' && clone[x][y] != 'V';
	}
	
	public static void floodfill(int x, int y, int steps, String path)
	{
		if(clone[x][y] == 'X')
		{
			if(steps < min)
			{
				min = steps;
				finalPath = path;
			}
			return;
		}
		
		clone[x][y] = 'V';
		for(int i = 0; i < 4; i++)
		{
			if(isValid(x + dx[i], y + dy[i]))
				floodfill(x + dx[i], y + dy[i], steps + 1, path + direction[i]);
		}
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
			
		grid = new char[12][12];
		
		grid[2][2] = 'X';
		grid[2][9] = 'X';
		grid[9][2] = 'X';
		grid[9][9] = 'X';
		
		grid[5][5] = '#';
		grid[5][6] = '#';
		grid[6][5] = '#';
		grid[6][6] = '#';
		grid[8][1] = '#';
		grid[8][2] = '#';
		grid[9][1] = '#';
		grid[8][9] = '#';
		grid[8][10] = '#';
		grid[9][10] = '#';
		
		int levels = sc.nextInt();
		while(levels-->0)
		{
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			min = Integer.MAX_VALUE;
			finalPath = "";
			
			clone = new char[12][12];
			for(int i = 0; i < 12; i++)
				for(int j = 0; j < 12; j++)
					clone[i][j] = grid[i][j];
				
			floodfill(x, y, 0, "");
			pw.println(min);
			pw.println(finalPath);
		}
		
		
		pw.flush();
		pw.close();
	}
	
	static class Pair
	{
		int x, y;
		
		public Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}

}
