//791A
import java.util.Scanner;

public class Bear
{
  public static int years(int k , int b)
  {
    int i = 0 ;
    while(k <= b)
    {
      k = k * 3;
      b = b *2;
      i++;
    }
    return i;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int b = sc.nextInt();
    System.out.println(years(k,b));
  }
}
