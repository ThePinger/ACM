//472A

import java.util.Scanner;

public class MathTut
{

  public static boolean isPrime(int x)
  {
    for(int i = 2 ; i < x ; i++)
      if(x % i == 0)
        return false;
    return true;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = n / 2 ;
    int b = n / 2 ;
    if(a + b != n)
      a++;
    while(a != n)
    {
      if(!isPrime(a) && !isPrime(b))
      {
        if(b > a)
          System.out.println(a + " " + b);
        else
          System.out.println(b + " " + a);
        break;
      }
      a++;
      b--;
    }

  }
}
