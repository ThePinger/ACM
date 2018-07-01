//1096
//The Islands

import java.io.*;
import java.util.*;

public class Main
{

    static int n, specialOne, specialTwo;
    static Point[] arr;
    static double[][] dist;
    static double[][][][][] memo;
    static Stack<Integer> stack;
    static PrintWriter pw = new PrintWriter(System.out);

    public static double dp(int cur, int preOne, int preTwo, int special1, int special2)
    {
        if(cur == n - 1)
            return dist[preOne][cur] + dist[preTwo][cur];

        if(memo[cur][preOne][preTwo][special1][special2] != -1)
            return memo[cur][preOne][preTwo][special1][special2];

        double takeOne = Double.MAX_VALUE, takeTwo = Double.MAX_VALUE;
        if(cur == specialOne || cur == specialTwo)
        {
            if(special1 == 0)
                takeOne = dist[preOne][cur] + dp(cur + 1, cur, preTwo, 1, special2);
            if(special2 == 0)
                takeTwo = dist[preTwo][cur] + dp(cur + 1, preOne, cur, special1, 1);
        }
        else
        {
            takeOne = dist[preOne][cur] + dp(cur + 1, cur, preTwo, special1, special2);
            takeTwo = dist[preTwo][cur] + dp(cur + 1, preOne, cur, special1, special2);            
        }

        return memo[cur][preOne][preTwo][special1][special2] = Math.min(takeOne, takeTwo);
    }

    public static void print(int cur, int preOne, int preTwo, int special1, int special2)
    {
        if(cur == n - 1)
        {
            pw.print(n - 1 + " ");
            return;
        }

        double takeOne = Double.MAX_VALUE, takeTwo = Double.MAX_VALUE;
        if(cur == specialOne || cur == specialTwo)
        {
            if(special1 == 0)
            {
                takeOne = dist[preOne][cur] + dp(cur + 1, cur, preTwo, 1, special2);
                if(takeOne == dp(cur, preOne, preTwo, special1, special2))
                {
                    pw.print(cur + " ");
                    print(cur + 1, cur, preTwo, 1, special2);
                    return;
                }
            }

            if(special2 == 0)
            {
                takeTwo = dist[preTwo][cur] + dp(cur + 1, preOne, cur, special1, 1);
                if(takeTwo == dp(cur, preOne, preTwo, special1, special2))
                {
                    stack.push(cur);
                    print(cur + 1, preOne, cur, special1, 1);
                    return;
                }
            }
        }
        else
        {
            takeOne = dist[preOne][cur] + dp(cur + 1, cur, preTwo, special1, special2);
            if(takeOne == dp(cur, preOne, preTwo, special1, special2))
            {
                pw.print(cur + " ");
                print(cur + 1, cur, preTwo, special1, special2);
                return;
            }            

            takeTwo = dist[preTwo][cur] + dp(cur + 1, preOne, cur, special1, special2);    
            if(takeTwo == dp(cur, preOne, preTwo, special1, special2))
            {
                stack.push(cur);
                print(cur + 1, preOne, cur, special1, special2);
                return;
            }            
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        
        while(true)
        {
            n = sc.nextInt();
            specialOne = sc.nextInt();
            specialTwo = sc.nextInt();

            if(n == 0 && specialOne == 0 && specialTwo == 0)
                break;

            arr = new Point[n];
            for(int i = 0; i < n; i++)
                arr[i] = new Point(sc.nextInt(), sc.nextInt());

            dist = new double[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    dist[i][j] = arr[i].dist(arr[j]);

            memo = new double[n][n][n][2][2];
            for(double[][][][] x : memo)
                for(double[][][] xx : x)
                    for(double[][] xxx : xx)
                        for(double[] xxxx : xxx)
                            Arrays.fill(xxxx, -1);

            double ans = dp(1, 0, 0, 0, 0);

            pw.printf("Case %d: %.2f\n0 ", t++, ans);
            stack = new Stack<>();
            print(1, 0, 0, 0, 0);
            while(!stack.isEmpty())
                pw.print(stack.pop() + " ");
            pw.println("0");
        }

        pw.flush();
        pw.close();
    }

    static class Point
    {
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public double square(double x)
        {
            return x * x;
        }
    
        public double dist(Point p)
        {
            return Math.sqrt(square(this.x - p.x) + square(this.y - p.y));
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