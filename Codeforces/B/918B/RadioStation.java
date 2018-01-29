//918B
//RadioStation

import java.util.*;
import java.io.*;

public class RadioStation
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        Server[] names = new Server[n];
        for(int i = 0; i < n; i++)
        {
            String nam = sc.next();
            String line = sc.next();
            String a = "";
            String b = "";
            String c = "";
            String d = "";
            int dots = 0;

            for(int j = 0; j < line.length(); j++)
                if(line.charAt(j) == '.') dots++;
                else
                {
                    if(dots == 0)
                        a += line.charAt(j);
                    if(dots == 1)
                        b += line.charAt(j);
                    if(dots == 2)
                        c += line.charAt(j);
                    if(dots == 3)
                        d += line.charAt(j);
                }

            names[i] = new Server(nam, Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c), Integer.parseInt(d));
        }   

        for(int i = 0; i < m; i++)
        {
            String nam = sc.next();
            String line = sc.next();
            sb.append(nam + " " + line + " #");
            String a = "";
            String b = "";
            String c = "";
            String d = "";
            int dots = 0;

            for(int j = 0; j < line.length() - 1; j++)
                if(line.charAt(j) == '.') dots++;
                else
                {
                    if(dots == 0)
                        a += line.charAt(j);
                    if(dots == 1)
                        b += line.charAt(j);
                    if(dots == 2)
                        c += line.charAt(j);
                    if(dots == 3)
                        d += line.charAt(j);
                }

            int aa = Integer.parseInt(a);
            int bb = Integer.parseInt(b);
            int cc = Integer.parseInt(c);
            int dd = Integer.parseInt(d);  
            for(int j = 0; j < names.length; j++)
            {
                Server tmp = names[j];
                if(tmp.a == aa && tmp.b == bb && tmp.c == cc && tmp.d == dd)
                {
                    sb.append(tmp.name + "\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }

    static class Server
    {
        int a, b, c, d;
        String name;

        public Server(String name, int a, int b, int c, int d)
        {
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
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