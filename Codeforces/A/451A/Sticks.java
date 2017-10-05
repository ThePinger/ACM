//451A

import java.util.*;

public class Sticks
{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    boolean f = true;
    while(n > 0 && m > 0)
    {
      n--;
      m--;
      f = !f;
    }
    if(f)
     System.out.println("Malvika");
    else
     System.out.println("Akshat");
  }
}
