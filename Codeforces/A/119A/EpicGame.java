//119A
import java.util.Scanner;

public class EpicGame
{

  public static int winner(int s , int a, int n)
  {
    int turn  = 0 ;
    while(n > 0)
    {
      if(turn == 0)
      {
        n -= gcd(s,n);
        turn = 1;
      }
      else
      {
        n -= gcd(a,n);
        turn = 0;
      }
    }
    if(turn == 1)
      return 0;
    return 1;
  }

  public static int gcd(int x , int y)
  {
    int max;
    if(x > y)
      max = y;
    else
      max = x;
    while(max > 1)
    {
      if(x % max == 0 && y % max == 0)
        return max;
      else
        max--;
    }
    return 1;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int s = sc.nextInt();
    int a = sc.nextInt();
    int n = sc.nextInt();
    System.out.println(winner(s , a , n));
  }
}
