//339B
//Xenia and RingRoad

import java.util.*;

public class RingRoad
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int houses = sc.nextInt();
    int tasks = sc.nextInt();
    long time = 0;
    int pos = 1;
    for(int i = 0 ; i < tasks ; i++)
    {
      int cur = sc.nextInt();
      if(pos > cur)
      {
        time += houses - pos + 1;
        pos = 1;
      }
      time += cur - pos;
      pos = cur;
    }
    System.out.println(time);
  }
}
