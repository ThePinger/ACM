
import java.util.*;

public class C
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue <Integer> pq = new PriorityQueue(Collections.reverseOrder());
    for(int i = 0 ; i < n ; i++) pq.add(sc.nextInt());

    int pre = pq.remove();
    int vis = (int) 1e9;
    while(!pq.isEmpty())
    {
      int boxes = 1;
      while(!pq.isEmpty())
      {
        int cur = pq.remove();
        if(cur == pre) boxes++;
        else{ pre = cur; break; }
      }

      if(vis == (int) 1e9) vis = boxes;
      else if(boxes > vis) vis += (boxes - vis);

    }

    System.out.println(vis);
  }
}
