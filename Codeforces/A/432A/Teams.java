
import java.util.*;

public class Teams
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int minContests = sc.nextInt();
    PriorityQueue <Integer> pq = new PriorityQueue<>();
    while(n-->0)
      pq.add(sc.nextInt());

    int teams = 0;
    int c = 0;
    while(!pq.isEmpty())
    {
      int tmp = pq.remove();
      if(tmp + minContests < 6) c++;
      else break;

      if(c == 3)
      {
        c = 0;
        teams++;
      }
    }
    System.out.println(teams);
  }
}
