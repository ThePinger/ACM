//11988
//LinkedList

import java.io.*;
import java.util.*;

public class Main
{

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(br.ready())
    {
      String s = br.readLine();
      //if(s.equals("0")) break;
      LinkedList <String> ll = new LinkedList<>();
      for(int i = 0 ; i < s.length() ; i++)
      {
        char tmp = s.charAt(i);
        if(tmp == '[')
        {
          StringBuilder bs = new StringBuilder();
          for(int j = i + 1 ; j < s.length() ; j++)
          {
            if(s.charAt(j) == '[' || s.charAt(j) == ']'){ i = j - 1 ; break; }
            if(j + 1 == s.length()) i = j;
            bs.append(s.charAt(j));
          }
          ll.addFirst(bs.toString());
        }
        else if(tmp != ']')
          ll.addLast(tmp + "");
      }

      while(ll.size() > 0)
        sb.append(ll.removeFirst());

      sb.append("\n");
    }
    System.out.print(sb);
  }
}
