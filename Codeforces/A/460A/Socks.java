//460A
import java.util.Scanner;

public class Socks
{
  public static int days(int n , int m)
  {
    int c = 0 ;
    int i = 0 ;
    while(n > 0)
    {
      i++;
      n--;
      c++;
      if(i == m)
      {
        n++;
        i = 0;
      }
    }
    return c ;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    System.out.print(days(n,m));
  }
}
