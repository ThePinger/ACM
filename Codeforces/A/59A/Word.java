//59A
import java.util.Scanner;


public class Word
{

  public static String word(String s)
  {
    int up = 0 ;
    int low = 0 ;
    for(int i = 0 ; i < s.length() ; i++)
    {
      if(Character.isLowerCase(s.charAt(i)))
        low++;
      else
        up++;
    }
    if(up > low)
      s = s.toUpperCase();
    else
      s = s.toLowerCase();
    return s;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    System.out.println(word(s));
  }
}
