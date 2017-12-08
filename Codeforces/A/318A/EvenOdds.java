//318A
//EvenOdds

import java.util.*;

public class EvenOdds
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long p = sc.nextLong();

    long mid;
    if(n % 2 == 0) mid = n / 2;
    else mid = (n / 2) + 1;

    if(p <= mid) System.out.println(p + p - 1);
    else         System.out.println((p - mid) + (p - mid));
  }
}
