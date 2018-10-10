//95E
//LuckyCountry

import java.io.*;
import java.util.*;

public class LuckyCountry
{

    static boolean[] vis;
    static ArrayList<Integer>[] adjList;
    static final int INF = (int) 1e9;

    public static int dfs(int cur)
    {
        int ans = 1;
        vis[cur] = true;
        for(int nxt : adjList[cur])
            if(!vis[nxt])
                ans += dfs(nxt);
        return ans;
    }

    public static boolean isLucky(int x)
    {
        while(x != 0)
        {
            int mod = x % 10;
            if(mod != 4 && mod != 7)
                return false;
            x /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for(int i = 0; i < m; i++)
        {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            adjList[a].add(b);
            adjList[b].add(a);
        }

        vis = new boolean[n];
        int[] count = new int[n + 1];
        for(int i = 0; i < n; i++)
            if(!vis[i])
                count[dfs(i)]++;

        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> steps = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {    
            int cnt = 1;
            while(cnt <= count[i])
            {
                size.add(i * cnt);
                steps.add(cnt);
                cnt <<= 1;
            }
        }

        int[] dp = new int[77778];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 0; i < size.size(); i++)
            for(int j = dp.length - size.get(i) - 1; j > -1; j--)
                dp[j + size.get(i)] = Math.min(dp[j + size.get(i)], dp[j] + steps.get(i));

        int min = INF;
        for(int i = 1; i < dp.length; i++)
            if(isLucky(i))
                min = Math.min(min, dp[i]);

        System.out.println(min == INF ? -1 : min - 1);
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