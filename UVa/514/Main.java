//514
//Rails

import java.util.*;
import java.io.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringBuilder sb = new StringBuilder();
     while(true)
     {
       int n = Integer.parseInt(br.readLine());
       if(n == 0)
         break ;

       while(true)
       {

         StringTokenizer st = new StringTokenizer(br.readLine());
         int a = Integer.parseInt(st.nextToken());
         if(a == 0)
           break ;

         ArrayList<Integer> train = new ArrayList<>();
         train.add(a);
         for(int i = 1 ; i < n ; i++)
           train.add(Integer.parseInt(st.nextToken()));

         Stack <Integer> station = new Stack<>();
         int curCar = 0;
         boolean f = true;
         loop : for(int i = 0 ; i < n ; i++)
         {

           int c = train.get(i);
           if(station.isEmpty())
             station.push(++curCar);

           while(curCar <= n)
           {
             if(station.peek() == c)
             {
               station.pop();
               break ;
             }
             else if(curCar == n)
             {
               f = false;
               break loop;
             }
             else
               station.push(++curCar);
           }
         }
         if(!f)
           sb.append("No\n");
         else
           sb.append("Yes\n");
       }
       sb.append("\n");
     }
     System.out.print(sb);
  }
}
