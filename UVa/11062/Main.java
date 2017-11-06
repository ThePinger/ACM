//11062
//Andy Second dictionary

import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TreeSet <String> set = new TreeSet<>();
    StringBuilder sb = new StringBuilder();
    while(br.ready())
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens())
      {
        String s = st.nextToken().toLowerCase();
        boolean hyph = false;
        for(int i = 0 ; i < s.length() ; i++)
        {
           if((s.charAt(i) > 96 && s.charAt(i) < 123) || (s.charAt(i) == '-' && i + 1 != s.length()))
              sb.append(s.charAt(i));
           else if(s.charAt(i) == '-' && i + 1 == s.length())
              hyph = true;
           else
           {
             if(sb.toString().length() > 0)
               set.add(sb.toString());
             sb = new StringBuilder();
             hyph = false;
           }
        }
        if(sb.toString().length() > 0 && !hyph)
        {
          set.add(sb.toString());
          sb = new StringBuilder();
        }
      }
    }
    StringBuilder builder = new StringBuilder();
    while(!set.isEmpty())
      builder.append(set.pollFirst() + "\n");
    System.out.print(builder);
  }
}
