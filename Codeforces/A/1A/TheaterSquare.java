//1A
import java.util.Scanner;

public class TheaterSquare
{
  public static long flags(long n , long m , long a)
  {
    long squareArea = n * m ;
    long rows = 0;
    long columns = 0;
    if(a == 1)
      return squareArea;
    while(n > 0)
    {
      rows++;
      n = n - a;
    }
    while(m > 0)
    {
      columns++;
      m = m - a;
    }
    return rows*columns ;
  }

  public static void main(String[] args)
  {
    Scanner sc =  new Scanner(System.in);
    long n = sc.nextInt();
    long m = sc.nextInt();
    long a = sc.nextInt();
    System.out.println(flags(n,m,a));
  }
}
