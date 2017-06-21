//379A
import java.util.Scanner;

public class Candles
{

  public static int candles(int candles , int av)
  {
    int hours = 0;
    int c = 0 ;
    while(candles > 0)
    {
      c++;
      hours++;
      candles--;
      if(c == av)
      {
        c = 0;
        candles++;
      }
    }
    return hours;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int candles = sc.nextInt();
    int av = sc.nextInt();
    System.out.println(candles(candles , av));
  }
}
