//12504
//Updating a dictionary

import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n  = Integer.parseInt(br.readLine());
    while(n-->0)
    {
      PriorityQueue <String> plus = new PriorityQueue<>();
      PriorityQueue <String> minus = new PriorityQueue<>();
      PriorityQueue <String> star = new PriorityQueue<>();
      String[] line = br.readLine().split(",");
      TreeMap<String , String> map = new TreeMap<>();
      for(int i = 0 ; i < line.length ; i++)
      {
        String key = "";
        String value = "";
        StringBuilder builder = new StringBuilder();
        for(int j = 0 ; j < line[i].length() ; j++)
        {
          char tmp = line[i].charAt(j);
          if(tmp == ':')
          {
            key = builder.toString();
            builder = new StringBuilder();
          }
          else if(tmp == '}')
            value = builder.toString();
          else if(tmp == '{')
            continue;
          else
            builder.append(tmp);
        }
        value = builder.toString();
        if(key.length() != 0 && value.length() != 0)
          map.put(key , value);
      }

      line = br.readLine().split(",");
      for(int i = 0 ; i < line.length ; i++)
      {
        String key = "";
        String value = "";
        StringBuilder builder = new StringBuilder();
        for(int j = 0 ; j < line[i].length() ; j++)
        {
          char tmp = line[i].charAt(j);
          if(tmp == ':')
          {
            key = builder.toString();
            builder = new StringBuilder();
          }
          else if(tmp == '}')
            value = builder.toString();
          else if(tmp == '{')
            continue;
          else
            builder.append(tmp);
        }
        value = builder.toString();
        if(value.length() != 0 && key.length() != 0)
        {
          if(map.containsKey(key))
          {
            if(!map.get(key).equals(value))
              star.add(key);
            map.remove(key);
          }
          else if(!map.containsKey(key))
            plus.add(key);
        }
      }

      while(!map.isEmpty())
      {
        String key = map.firstKey();
        minus.add(key);
        map.remove(key);
      }

      if(plus.isEmpty() && minus.isEmpty() && star.isEmpty())
        sb.append("No changes\n");

      boolean f = true;
      while(!plus.isEmpty())
      {
        if(f)
        {
          f = false;
          sb.append("+");
        }
        String tmp = plus.remove();
        if(plus.isEmpty())
         sb.append(tmp + "\n");
        else
         sb.append(tmp + ",");
      }

      f = true;
      while(!minus.isEmpty())
      {
        if(f)
        {
          f = false;
          sb.append("-");
        }
        String tmp = minus.remove();
        if(minus.isEmpty())
         sb.append(tmp + "\n");
        else
         sb.append(tmp + ",");
      }

      f = true;
      while(!star.isEmpty())
      {
        if(f)
        {
          f = false;
          sb.append("*");
        }
        String tmp = star.remove();
        if(star.isEmpty())
         sb.append(tmp + "\n");
        else
         sb.append(tmp + ",");
      }

      sb.append("\n");
    }
    System.out.print(sb);
  }
}
