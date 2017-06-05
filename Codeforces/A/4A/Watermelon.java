//4A
import java.util.Scanner;

public class Watermelon
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int kilos = sc.nextInt();
    if(kilos % 2 == 0 && kilos != 2)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
