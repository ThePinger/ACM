//733 A
import java.util.Scanner;
public class Grasshopper
{
  public static int maxAbility(String s)
  {
    int max = 0;
    int steps = 0;
    for(int i = 0  ; i < s.length() ; i++)
    {
      steps++;
      if(!isVowel(s.charAt(i)) && i+1 == s.length())
        steps++;
      if(isVowel(s.charAt(i)) || i+1 == s.length())
      {
        if(steps > max)
          max = steps;
        steps = 0;
      }
    }
    return max;
  }

  public static boolean isVowel(char c)
  {
    switch(c)
    {
      case 'A':
      case 'E':
      case 'I':
      case 'O':
      case 'U':
      case 'Y':return true;
    }
    return false;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String n = sc.next();
    System.out.println(maxAbility(n));
  }
}
