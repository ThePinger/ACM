//11080
//Place the Guards

import java.io.*;
import java.util.*;

public class Main
{

    static int[] colour;
    static ArrayList<Integer>[] adjList;

    public static int bfs(int start)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colour[start] = 1;

        int red = 1;
        int blue = 0;
        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(int nxt : adjList[cur])
                if(colour[nxt] == -1)
                {
                    q.add(nxt);
                    colour[nxt] = 1 - colour[cur];
                    if(colour[nxt] == 1) red++;
                    else blue++;
                }
                else if(colour[cur] == colour[nxt]) return -1;
        }

        if(blue == 0) return 1;
        return Math.min(red, blue);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            int junctions = sc.nextInt();
            int streets   = sc.nextInt();

            if(streets == 0)
            {
                pw.println(junctions);
                continue;
            }

            colour = new int[junctions];
            adjList = new ArrayList[junctions];
            for(int i = 0; i < junctions; i++)
                adjList[i] = new ArrayList<>();

            while(streets-->0)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                adjList[x].add(y);
                adjList[y].add(x);
            }

            int answer = 0;
            Arrays.fill(colour, -1);
            for(int i =  0; i < junctions; i++)
                if(colour[i] == -1)
                {
                    int tmp = bfs(i);
                    if(tmp == -1)
                    {
                        answer = -1;
                        break;
                    }
                    answer += tmp;
                }

            pw.println(answer);
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
