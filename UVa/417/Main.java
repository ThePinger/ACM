//417
//WordIndex

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        TreeSet<StringCompare> set = new TreeSet<>();
        TreeMap<String, Integer> map = new TreeMap<>();

        for(int a = 'a'; a <= 'z'; a++)
        {
            char aa = (char) a;
            for(int b = a + 1; b <= 'z'; b++)
            {
                char bb = (char) b;
                for(int c = b + 1; c <= 'z'; c++)
                {
                    char cc = (char) c;
                    for(int d = c + 1; d <= 'z'; d++)
                    {
                        char dd = (char) d;
                        for(int e = d + 1; e <= 'z'; e++)
                        {
                            char ee = (char) e;
                            set.add(new StringCompare("" + aa + bb + cc + dd + ee));
                        }
                        set.add(new StringCompare("" + aa + bb + cc + dd));
                    }
                    set.add(new StringCompare("" + aa + bb + cc));
                }
                set.add(new StringCompare("" + aa + bb));
            }
            set.add(new StringCompare("" + aa));            
        }

        int count = 1;
        while(!set.isEmpty())
            map.put(set.pollFirst().s, count++);

        while(br.ready())
        {
            Integer idx = map.get(br.readLine());
            pw.println(idx == null ? 0 : idx);
        }

        pw.flush();
        pw.close();
    }

    static class StringCompare implements Comparable<StringCompare>
    {
        String s;

        public StringCompare(String s)
        {
            this.s = s;
        }

        public int compareTo(StringCompare sc)
        {
            if(s.length() == sc.s.length())
            {
                for(int i = 0; i < s.length(); i++)
                    if(s.charAt(i) != sc.s.charAt(i))
                        return s.charAt(i) - sc.s.charAt(i);
            }
            return s.length() - sc.s.length();
        }
    }
}