//11389
//The Bus Driver Problem

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
            int d = sc.nextInt();
            int r = sc.nextInt();

            if(n == 0 && d == 0 && r == 0) break;

            PriorityQueue<Integer> morning = new PriorityQueue<>();
            PriorityQueue<Integer> evening = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0; i < n; i++) morning.add(sc.nextInt());
            for(int i = 0; i < n; i++) evening.add(sc.nextInt());

            long overtime = 0;
            while(!morning.isEmpty())
            {
                int cur = morning.poll() + evening.poll();
                if(cur > d) overtime += (cur - d) * r;
            }

            pw.println(overtime);
        }

        pw.flush();
        pw.close();
    }
}