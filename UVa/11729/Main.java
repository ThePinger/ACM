//11729
//CommandoWar

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = 1;
        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
            while(n-->0)
                pq.add(new Pair(sc.nextInt(), sc.nextInt()));

            int cur = 0;
            int end = 0;
            while(!pq.isEmpty())
            {
                Pair p = pq.poll();
                cur += p.brief;
                end = Math.max(end, cur + p.end);
            }

            pw.printf("Case %d: %d\n", t++, end);
        }

        pw.flush();
        pw.close();
    }

    static class Pair implements Comparable<Pair>
    {
        int brief, end;

        public Pair(int brief, int end)
        {
            this.brief = brief;
            this.end = end;
        }

        public int compareTo(Pair p)
        {
            return this.end - p.end;
        }
    }
}