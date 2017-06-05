//96A
import java.util.Scanner;

public class Football
{

  public static String dangerous(String s)
  {
    int zeros = 0 ;
    int ones = 0;
    for(int i = 0 ; i < s.length() ; i++)
    {
      if(s.charAt(i) == '0')
      {
        zeros++;
        ones = 0;
      }
      else
      {
        ones++;
        zeros = 0 ;
      }
      if(zeros == 7 || ones == 7)
        return "YES";
    }
    return "NO";
  }

  public static void main(String[] args)
  {
    Scanner sc =  new Scanner(System.in);
    String s = sc.next();
    System.out.println(dangerous(s));
  }
}
