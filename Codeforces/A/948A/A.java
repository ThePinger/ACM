
import java.util.*;
import java.io.*;

public class A 
{

	static boolean isValid(int i, int j, int n, int m)
	{
		return i > -1 && j > -1 && i < n && j < m;
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] grid = new char[n][m];
		
		for(int i = 0; i < n; i++)
			grid[i] = sc.next().toCharArray();
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(grid[i][j] == '.')
					grid[i][j] = 'D';
		
		boolean flag = true;
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
			{
				if(grid[i][j] == 'W')
				{
					for(int c = 0; c < 4; c++)
					{
						int xx = i + dx[c];
						int yy = j + dy[c];
						if(isValid(xx, yy, n, m))
						{
							if(grid[xx][yy] == 'S')
								flag = false;
						}
					}
				}
			}
		
		if(flag)
		{
			System.out.println("Yes");
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
					System.out.print(grid[i][j]);
				System.out.println();
			}
		}
		else System.out.println("No");
		
	}
	
	static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s)
        {
          br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String s) throws FileNotFoundException
        {
          br = new BufferedReader(new FileReader(new File((s))));
        }

        public String next() throws IOException
        {
          while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
          return st.nextToken();
        }

        public int nextInt() throws IOException
        {
          return Integer.parseInt(next());
        }

        public long nextLong() throws IOException
        {
          return Long.parseLong(next());
        }

        public String nextLine() throws IOException
        {
          return br.readLine();
        }

        public double nextDouble() throws IOException
        {
          String x = next();
          StringBuilder sb = new StringBuilder("0");
          double res = 0, f = 1;
          boolean dec = false, neg = false;
          int start = 0;
          if (x.charAt(0) == '-')
          {
            neg = true;
            start++;
          }
          for (int i = start; i < x.length(); i++)
            if (x.charAt(i) == '.')
            {
              res = Long.parseLong(sb.toString());
              sb = new StringBuilder("0");
              dec = true;
            } else
            {
              sb.append(x.charAt(i));
              if (dec)
                f *= 10;
            }
          res += Long.parseLong(sb.toString()) / f;
          return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException
        {
          return br.ready();
        }
    }

}
