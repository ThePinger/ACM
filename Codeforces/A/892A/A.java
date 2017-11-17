
import java.util.*;

public class A
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long cola = 0;
    for(int i = 0 ; i < n ; i++)
       cola += sc.nextLong();

    PriorityQueue <Long> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int i = 0 ; i < n ; i++)
       pq.add(sc.nextLong());

    long cups = pq.remove() + pq.remove();
    if(cups >= cola)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
