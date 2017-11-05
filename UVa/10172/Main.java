//10172
//The Lonesome Cargo Distributor

import java.io.*;
import java.util.*;

public class Main
{
  static int time;
  static int cargos;
  static int stations;
  static int carrierMax;
  static int maxQueueCapacity;
  static Stack<Integer> carrier;
  static Queue<Integer>[] stationsQueue;

  public static void unload(int cur)
  {
     while(!carrier.isEmpty())
     {
       int cargo = carrier.peek();
       if(cargo != cur)
         if(stationsQueue[cur].size() < maxQueueCapacity)
            stationsQueue[cur].add(cargo);
         else
            return ;
       else
         cargos--;
       time++;
       carrier.pop();
     }
  }

  public static void load(int cur)
  {
    while(!stationsQueue[cur].isEmpty() && carrier.size() < carrierMax)
    {
       carrier.push(stationsQueue[cur].remove());
       time++;
    }
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    while(n-->0)
    {

      StringTokenizer st = new StringTokenizer(br.readLine());
      stations = Integer.parseInt(st.nextToken());
      carrierMax = Integer.parseInt(st.nextToken());
      maxQueueCapacity = Integer.parseInt(st.nextToken());
      carrier = new Stack<>();
      stationsQueue = new Queue[stations + 1];
      cargos = 0;
      for(int i = 1 ; i < stations + 1 ; i++)
      {
         stationsQueue[i] = new LinkedList<>();
         st = new StringTokenizer(br.readLine());
         cargos += Integer.parseInt(st.nextToken());
         while(st.hasMoreTokens())
            stationsQueue[i].add(Integer.parseInt(st.nextToken()));
      }

      time = 0;
      int loops = 0;
      loop : while(true)
      {
        for(int j = 1 ; j < stations + 1 ; j++)
        {
          if(cargos == 0)
            break loop;
          unload(j);
          load(j);
          time += 2;
        }
        loops++;
      }
      time -= 2;
      sb.append(time + "\n");
    }
    System.out.print(sb);
  }
}
