//11995
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line = br.readLine()) != null && !line.equals(""))
    {
      int n = Integer.parseInt(line);
      String[] s;
      Stack<Integer> st = new Stack <Integer>();
      Queue<Integer> q = new LinkedList<Integer>();
      PriorityQueue <Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
      boolean stack = true;
      boolean queue = true;
      boolean priority = true;
      int tmp;
      for(int i = 0 ; i < n; i++)
      {
        s = br.readLine().split(" ");
        tmp = Integer.parseInt(s[1]);
        if(s[0].equals("1"))
        {
          st.push(tmp);
          q.add(tmp);
          pq.add(tmp);
        }
        else
        {
          if(st.isEmpty() || st.pop() != tmp)
            stack = false;
          if(q.isEmpty() || q.remove() != tmp)
            queue = false;
          if(pq.isEmpty() || pq.poll() != tmp )
            priority = false;
        }
      }
      if(stack && !queue && !priority)
        System.out.println("stack");
      else if(queue && !stack && !priority)
        System.out.println("queue");
      else if(priority && !stack && !queue)
        System.out.println("priority queue");
      else if(!stack && !queue && !priority)
        System.out.println("impossible");
      else
        System.out.println("not sure");
    }
  }
}
