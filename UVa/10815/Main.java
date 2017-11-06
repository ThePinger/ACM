//10815
//Andy first dictionary

import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TreeSet <String> set = new TreeSet<>();
    while(br.ready())
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens())
      {
        String s = st.nextToken().toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++)
           if(s.charAt(i) > 96 && s.charAt(i) < 123)
              sb.append(s.charAt(i));
           else
           {
             if(sb.toString().length() > 0)
               set.add(sb.toString());
             sb = new StringBuilder();
           }
        if(sb.toString().length() > 0)
          set.add(sb.toString());
      }
    }
    StringBuilder builder = new StringBuilder();
    while(!set.isEmpty())
      builder.append(set.pollFirst() + "\n");
    System.out.print(builder);
  }
}
