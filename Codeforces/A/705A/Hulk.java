//705A
import java.util.Scanner;

public class Hulk
{

  public static String feeling(int n)
  {
    String a = "I hate that ";
    String b = "I love that ";
    String c = "I hate it ";
    String d = "I love it ";
    String feel = "";
    if(n % 2 == 0)
      feel += d;
    else
      feel += c;
    n--;
    while(n > 0)
    {
      if(n % 2 == 0)
        feel = b + feel;
      else
        feel = a + feel;
      n--;
    }
    return feel;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(feeling(n));
  }
}
