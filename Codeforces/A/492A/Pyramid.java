//492A
import java.util.Scanner;

public class Pyramid
{

  public static int levels(int n)
  {
    int level = 1;
    int cubes = 1;
    n--;
    while(n > 0)
    {
      level++;
      cubes += level;
      n -= cubes;
    }
    if(n < 0)
      level--;
    return level;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(levels(n));
  }
}
