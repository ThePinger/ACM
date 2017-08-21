
import java.io.*;
import java.util.*;

public class A
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    for(int i = 0 ; i < 2 * n ; i++)
    {
      int tmp = sc.nextInt();
      pq.add(tmp);
      q.add(tmp);
    }
    boolean f = true;
    for(int i = 0 ; i < n ; i++)
      if(pq.poll() <= q.poll())
      {
        f = false;
        break;
      }
    if(f)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
