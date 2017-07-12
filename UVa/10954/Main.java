import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    String[] s;
    while(n > 0)
    {
      s = br.readLine().split(" ");
      int cost = 0;
      for(int i = 0 ; i < n ; i++)
        pq.add(Integer.parseInt(s[i]));
      while(!pq.isEmpty())
      {
        int tmp = pq.poll();
        if(!pq.isEmpty())
        {
          tmp = tmp + pq.poll();
          cost = cost + tmp;
          pq.add(tmp);
        }
      }
      System.out.println(cost);
      n = Integer.parseInt(br.readLine());
    }
  }
}
