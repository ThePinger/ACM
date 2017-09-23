//69A
//Young Physicist

import java.util.Scanner;

public class YoungPhy
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = 0;
    int b = 0;
    int c = 0;
    while(n-->0)
    {
      a += sc.nextInt();
      b += sc.nextInt();
      c += sc.nextInt();
    }
    if(a == 0 && b == 0 && c == 0)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
