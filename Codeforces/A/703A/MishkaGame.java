//703A

import java.util.*;

public class MishkaGame
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int mishka = 0;
    int chris  = 0;

    while(n-->0)
    {
      int scoreM = sc.nextInt();
      int scoreC = sc.nextInt();
      if(scoreM > scoreC) mishka++;
      else if(scoreC > scoreM) chris++;
    }

    if(mishka > chris) System.out.println("Mishka");
    else if (chris > mishka) System.out.println("Chris");
    else System.out.println("Friendship is magic!^^");
  }
}
