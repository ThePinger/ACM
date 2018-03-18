//124
//Following Orders

import java.io.*;
import java.util.*;

public class Main 
{

    static char[] chars;
    static boolean[] visited;
    static ArrayList<String> answers;
    static ArrayList<Integer>[] adjList;
    static TreeMap<Character, Integer> map;

    public static void topoSort(String ans)
    {
        if(ans.length() == chars.length)
        {
            answers.add(ans);
            return;
        }

        for(int i = 0; i < chars.length; i++)
        {
            if(!visited[i] && !parentAdded(i))
            {
                visited[i] = true;
                topoSort(ans + chars[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean parentAdded(int cur)
    {
        for(int nxt : adjList[cur])
            if(visited[nxt])
                return true;
        return false;
    }


    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;

        while(sc.ready())
        {
            if(t++ != 1) pw.println();
         
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            chars = new char[st.countTokens()];
            for(int i = 0; i < chars.length; i++)
                chars[i] = st.nextToken().charAt(0);

            Arrays.sort(chars);

            map = new TreeMap<>();
            for(int i = 0; i < chars.length; i++)
                map.put(chars[i], i);

            visited = new boolean[chars.length];
            adjList = new ArrayList[chars.length];
            for(int i = 0; i < adjList.length; i++)
                adjList[i] = new ArrayList<>();

            st = new StringTokenizer(sc.nextLine());
            while(st.hasMoreTokens())
            {
                int a = map.get(st.nextToken().charAt(0));
                int b = map.get(st.nextToken().charAt(0));
                adjList[a].add(b);
            }

            answers = new ArrayList<>();
            topoSort("");

            for(int i = 0; i < answers.size(); i++)
                pw.println(answers.get(i));

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
