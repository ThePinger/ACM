//148A

import java.util.Scanner;

public class Dragons
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int l = sc.nextInt();
    int m = sc.nextInt();
    int n = sc.nextInt();
    int d = sc.nextInt();
    int affected = 0;
    int c = 1;
    while(c <= d)
    {
      if(c % k == 0 || c % l == 0 || c % m == 0 || c % n == 0)
        affected++;
      c++;
    }
    System.out.println(affected);
  }
}
