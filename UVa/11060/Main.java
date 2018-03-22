//11060
//Beverages

import java.io.*;
import java.util.*;

public class Main 
{

    static int[] inComing;
    static String[] drinks;
    static boolean[] visited;
    static Queue<String> answer;
    static ArrayList<Integer>[] adjList;
    static TreeMap<String, Integer> stringToNum;

    public static void bfs()
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < inComing.length; i++)
            if(inComing[i] == 0)
                pq.add(i);

        while(!pq.isEmpty())
        {
            int cur = pq.poll();
            answer.add(drinks[cur]);
            for(int nxt : adjList[cur])
            {
                inComing[nxt]--;
                if(inComing[nxt] == 0)
                    pq.add(nxt);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;

        while(sc.ready())
        {
            int n = sc.nextInt();
            drinks = new String[n];
            inComing = new int[n];
            stringToNum = new TreeMap<>();
            for(int i = 0; i < n; i++)
                drinks[i] = sc.next();

            for(int i = 0; i < n; i++)
                stringToNum.put(drinks[i], i);

            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            int relations = sc.nextInt();
            while(relations-->0)
            {
                int x = stringToNum.get(sc.next());
                int y = stringToNum.get(sc.next());
                adjList[x].add(y);
                inComing[y]++;
            }

            answer = new LinkedList<>();
            bfs();  
                    
            pw.print("Case #" + (t++) + ": Dilbert should drink beverages in this order: ");
            while(!answer.isEmpty())
                if(answer.size() == 1)
                    pw.print(answer.poll() + ".");
                else 
                    pw.print(answer.poll() + " ");
                    
            pw.println();
            pw.println();
            sc.nextLine();
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
