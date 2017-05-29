import java.util.Scanner ;
public class Elephant
{
  public static int steps(int x)
  {
    int s = 0 ;
    int n = 0 ;
    while( x > s )
    {
      s = s + 5 ;
      n++;
    }
    return n ;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    System.out.println(steps(x));
  }
}
