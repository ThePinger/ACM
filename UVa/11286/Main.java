//11286

import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true)
    {
      int n = Integer.parseInt(br.readLine());
      int size = n;
      TreeMap<String , Integer> map = new TreeMap<>();
      if(n == 0) break;
      while(n-->0)
      {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
          pq.add(Integer.parseInt(st.nextToken()));

        StringBuilder builder = new StringBuilder();
        while(!pq.isEmpty())
          builder.append(pq.remove());

        String tmp = builder.toString();
        if(map.containsKey(tmp))
          map.put(tmp , map.get(tmp) + 1);
        else
          map.put(tmp , 1);
      }

      int max = map.remove(map.lastKey());
      int sum = max;
      boolean f = true;
      while(!map.isEmpty())
      {
         int value = map.remove(map.lastKey());
         if(value == max) sum += value;
         else if(value > max)
         {
           max = value; 
           sum = max;
         }
      }
      sb.append(sum + "\n");
    }
    System.out.print(sb);
  }
}
