//236A
import java.util.Scanner;
import java.util.ArrayList;

public class MaleOrFemale
{

  public static String chat(String s)
  {
    ArrayList <Character> c = new ArrayList<Character>();
    for(int i = 0 ; i < s.length() ; i++)
    {
      if(!c.contains((Character) s.charAt(i)))
        c.add(s.charAt(i));
    }
    if(c.size() % 2 == 0 )
      return "CHAT WITH HER!";
    else
      return "IGNORE HIM!";
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    System.out.println(chat(s));
  }
}
