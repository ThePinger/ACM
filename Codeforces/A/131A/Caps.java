//131A
import java.util.Scanner;

public class Caps
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    boolean flag = true;
    for(int i = 1 ; i < s.length() ; i++)
    {
      if(Character.isLowerCase(s.charAt(i)))
        flag = false;
    }
    char c = s.charAt(0);
    if(flag && Character.isLowerCase(c))
    {
      s = s.substring(1).toLowerCase();
      s = Character.toUpperCase(c) + s ;
    }
    else if(flag && Character.isUpperCase(c))
      s = s.toLowerCase();
    System.out.println(s);
  }
}
