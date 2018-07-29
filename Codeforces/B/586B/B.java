//586B
//Laurenty and Shop

import java.io.*;
import java.util.*;

public class B
{

	static int[][][] grid;
	static int[][][][][] memo;
	
	public static int dp(int x, int y, int xx, int yy, int diff)
	{
		if(x == -1 || y == 0 || xx == -1 || yy == 0) return (int) 1e9;
		if(x == 0 && y == 1 && xx == 0 && yy == 1 && diff == 1)
			return 0;
		
		if(memo[x][y][xx][yy][diff] != -1) 
			return memo[x][y][xx][yy][diff];
		
		int up = grid[2][y][y] + grid[2][yy][yy] + dp(x - 1, y, xx - 1, yy, diff);
		int upL = grid[2][y][y] + grid[xx][yy - 1][yy] + dp(x - 1, y, xx, yy - 1, 1);
		int lUp = grid[x][y - 1][y] + grid[2][yy][yy] + dp(x, y - 1, xx - 1, yy, 1);
		int left = grid[x][y - 1][y] + grid[xx][yy - 1][yy] + dp(x, y - 1, xx, yy - 1, diff);
		
		return memo[x][y][xx][yy][diff] = Math.min(Math.min(up, left), Math.min(upL, lUp));
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		grid = new int[3][n + 1][n + 1];
		for(int i = 0; i < 2; i++)
			for(int j = 1; j < n; j++)
				grid[i][j][j + 1] = sc.nextInt();
		
		for(int i = 1; i < n + 1; i++)
			grid[2][i][i] = sc.nextInt();
		
		memo = new int[2][n + 1][2][n + 1][2];
		for(int[][][][] x : memo)
			for(int[][][] xx : x)
				for(int[][] xxx : xx)
					for(int[] xxxx : xxx)
						Arrays.fill(xxxx, -1);
		
		pw.println(dp(1, n, 1, n, 0));
		//trace(1, n, 1, n, 0);
		pw.flush();
		pw.close();
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
