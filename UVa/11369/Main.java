//11369
//Shopaholic

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out); 
        
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            while(n-->0)
                pq.add(sc.nextInt());

            long discount = 0;
            while(pq.size() > 2)
            {
                pq.poll(); pq.poll();
                discount += pq.poll();
            }

            pw.println(discount);
        }

        pw.flush();
        pw.close();
    }
}