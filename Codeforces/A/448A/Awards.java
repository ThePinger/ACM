//448A

import java.util.*;

public class Awards
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int cups = sc.nextInt() + sc.nextInt() + sc.nextInt();
    int medals = sc.nextInt() + sc.nextInt() + sc.nextInt();
    int shelves = sc.nextInt();

    while(shelves-->0)
    {
      if(cups > 0) cups -= 5;
      else if(medals > 0) medals -= 10;
    }

    if(cups > 0 || medals > 0) System.out.println("NO");
    else System.out.println("YES");
  }
}
