//11550
//Demanding Dilemma

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            int vert = sc.nextInt();
            int edge = sc.nextInt();
            int[][] graph = new int[vert][edge];
            boolean[][] adjMat = new boolean[vert][vert];

            for(int i = 0; i < vert; i++)
                for(int j = 0; j < edge; j++)
                    graph[i][j] = sc.nextInt();

            boolean flag = true;
            for(int j = 0; j < edge; j++)
            {
                int count = 0;
                int x = -1;
                int y = -1;
                for(int i = 0; i < vert; i++)
                    if(graph[i][j] == 1)
                    {
                        count++;
                        if(x == -1) x = i;
                        else y = i;
                    }

                if(count != 2 || adjMat[x][y])
                {
                    flag = false;
                    break;
                }
                adjMat[x][y] = adjMat[y][x] = true;
            }

            if(flag) pw.println("Yes");
            else pw.println("No");
        }

        pw.flush();
        pw.close();
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
