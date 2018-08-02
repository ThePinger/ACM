//777C
//AlyonaAndSpreadSheet

import java.io.*;
import java.util.*;

public class AlyonaAndSpreadSheet
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] sheet = new int[n][m];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                sheet[i][j] = sc.nextInt();

        if(n > 5000)
        {
            TreeSet<Integer>[] sorted = new TreeSet[n];
            for(int i = 0; i < n; i++)
                sorted[i] = new TreeSet<>();
            
            for(int i = 0; i < m; i++)
            {
                int dist = 1;
                for(int j = 0; j < n - 1; j++)
                {
                    sorted[j].add(dist);
                    if(sheet[j][i] <= sheet[j + 1][i])
                        dist++;
                    else dist = 1;
                }
                sorted[n - 1].add(dist);
            }

            int q = sc.nextInt();
            while(q-->0)
            {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;
                pw.println(sorted[r].contains(r - l + 1) || l == r || sorted[r].higher(r - l + 1) != null ? "Yes" : "No");
            }
    
        }
        else
        {
            boolean[][] sorted = new boolean[n][n];
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    boolean flag = true;
                    sorted[j][j] = true;
                    for(int c = j + 1; c < n; c++)
                    {
                        if(sheet[c - 1][i] > sheet[c][i]) flag = false;
                        if(!sorted[j][c]) sorted[j][c] = flag;
                    }
                }
            }

            int q = sc.nextInt();
            while(q-->0)
                pw.println(sorted[sc.nextInt() - 1][sc.nextInt() - 1] ? "Yes" : "No");
        }

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