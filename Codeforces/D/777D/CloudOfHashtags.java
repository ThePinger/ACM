//777D
//CloudOfHashtags

import java.io.*;
import java.util.*;

public class CloudOfHashtags
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        String[] arr = new String[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = sc.next();

        String[] answer = new String[n];
        answer[n - 1] = arr[n - 1];
        for(int i = n - 2; i > -1; i--)
        {
            String s = "#";
            boolean allEqual = true;
            for(int j = 1; j < Math.min(answer[i + 1].length(), arr[i].length()); j++)
            {
                char tmp1 = arr[i].charAt(j);
                char tmp2 = answer[i + 1].charAt(j);
                if(tmp1 < tmp2)
                {
                    s = arr[i];
                    allEqual = false;
                    break;
                }
                else if(tmp1 > tmp2)
                {
                    s = arr[i].substring(0, j);
                    allEqual = false;
                    break;
                }
            }

            if(allEqual) s = answer[i + 1].length() > arr[i].length() ? arr[i] : answer[i + 1];

            answer[i] = s;
        }

        for(int i = 0; i < n; i++)
            pw.println(answer[i]);

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