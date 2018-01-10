//11900
//Boiled Eggs

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int tc = 1;
        
        while(t-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int eggs = Integer.parseInt(st.nextToken());
            int maxEggs = Integer.parseInt(st.nextToken());
            int maxGrams = Integer.parseInt(st.nextToken());
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                pq.add(Integer.parseInt(st.nextToken()));

            int max = 0;
            int curSize = 0;
            while(!pq.isEmpty())
            {
                int cur = pq.peek();
                if(cur + curSize > maxGrams)
                    break;
                
                curSize += pq.remove();
                max++;
                if(max == maxEggs)
                    break;
            }

            sb.append("Case " + tc + ": " + max + "\n");
            tc++;
        }       
        System.out.print(sb);
    }
}