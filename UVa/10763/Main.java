//10763
//Foreign Exchange

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);  

        while(true)
        {
            int n = sc.nextInt();
            TreeMap<Pair, Integer> map = new TreeMap<>();

            if(n == 0) break;

            while(n-->0)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Pair p = new Pair(a, b);
                if(map.containsKey(p))
                    map.put(p, map.get(p) + 1);
                else
                    map.put(p, 1);
            }

            boolean flag = true;
            while(!map.isEmpty())
            {
                Pair p = map.firstKey();
                int v = map.get(map.firstKey());
                Pair tmp = new Pair(p.b, p.a);
                if(map.containsKey(tmp) && map.get(tmp) == v)
                {
                    map.pollFirstEntry();
                    map.remove(tmp);
                }
                else
                {
                    flag = false;
                    break;
                }
            }

            pw.println(flag ? "YES" : "NO");
        }

        pw.flush();
        pw.close();
    }

    static class Pair implements Comparable<Pair> 
    {
        int a, b;

        public Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p)
        {
            if(this.a == p.a)
                return this.b - p.b;
            return this.a - p.a;
        }
    }
}