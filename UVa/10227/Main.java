//10227
//Forests

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        br.readLine();

        while(n-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            TreeSet<Integer>[] set = new TreeSet[p];
            for(int i = 0; i < p; i++)
                set[i] = new TreeSet<>();

            while(true)
            {
                String s = br.readLine();
                if(s == null) break;

                st = new StringTokenizer(s);
                if(st.countTokens() == 0) break;

                int per = Integer.parseInt(st.nextToken()) - 1;
                int tre = Integer.parseInt(st.nextToken());
                set[per].add(tre);
            }

            TreeSet<String> opinions = new TreeSet<>();
            for(int i = 0; i < p; i++)
            {
                StringBuilder sb = new StringBuilder();
                while(!set[i].isEmpty())
                    sb.append(set[i].pollFirst());
                opinions.add(sb.toString());
            }
            
            pw.println(opinions.size());
            if(n != 0) pw.println();
        }

        pw.flush();
        pw.close();
    }
}