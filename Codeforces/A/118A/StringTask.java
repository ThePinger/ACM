//118A
//StringTask

import java.util.*;
public class StringTask
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String s = sc.next().toLowerCase();
    StringBuilder sb = new StringBuilder();
    for(int i = 0 ; i < s.length() ; i++)
    {
      char c = s.charAt(i);
      if(c == 'a' || c == 'e'|| c == 'o'|| c == 'y'|| c == 'u'|| c == 'i')
        continue;
      else
      {
        sb.append('.');
        sb.append(c);
      }
    }
    System.out.println(sb.toString());
  }
}
