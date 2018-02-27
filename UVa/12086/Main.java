//12086
//Potentiometers

import java.io.*;
import java.util.*;

public class Main
{
    static int[] arrCur, fenwickTree;

    public static void updateAdd(int idx, int v)
    {
        while(idx < fenwickTree.length)
        {
            fenwickTree[idx] += v;
            idx += (idx & -idx);
        }
    }

    public static void updateRemove(int idx, int v)
    {
        while(idx < fenwickTree.length)
        {
            fenwickTree[idx] -= v;
            idx += (idx & -idx);
        }
    }

    public static int query(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            sum += fenwickTree[n];
            n -= (n & -n);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;

        while(true)
        {
            int n = sc.nextInt();
            if(n == 0) break;

            if(t != 1) pw.println();

            arrCur = new int[n + 1];
            fenwickTree = new int[n + 1];
            for(int i = 1; i < n + 1; i++)
            {
                arrCur[i] = sc.nextInt();
                updateAdd(i, arrCur[i]);
            }

            pw.println("Case " + (t++) + ":");
            while(true)
            {
                String s = sc.next();
                if(s.equals("END")) break;

                if(s.equals("S"))
                {
                    int idxOrigin = sc.nextInt();
                    int newValue  = sc.nextInt();

                    if(idxOrigin != 0) updateRemove(idxOrigin, arrCur[idxOrigin]);
                    if(newValue != 0) updateAdd(idxOrigin, newValue);
                    arrCur[idxOrigin] = newValue;
                }
                else
                {
                    int right = sc.nextInt();
                    int left  = sc.nextInt();

                    if(right != 1)
                        pw.println(query(left) - query(right - 1));
                    else
                        pw.println(query(left));
                }
            }
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
