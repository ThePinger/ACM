
import java.io.*;
import java.util.*;

public class B
{
  public static void main(String[] args)throws IOException
  {
    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = sc.nextInt();
    int [] lastVisit = new int[200001];
    boolean [] visited = new boolean[200001];
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0 ; i < n ; i++)
    {
      int tmp = sc.nextInt();
      q.add(tmp);
      visited[tmp] = true;
    }

    for(int i = 0 ; i < n ; i++)
    {
      int tmp = q.remove();
      lastVisit[tmp] = i;
    }

    int last = 0;
    int min = (int) 1e9;
    for(int i = 0 ; i < 200001 ;i++)
    {
      if(lastVisit[i] < min && visited[i])
      {
        last = i;
        min = lastVisit[i];
      }
    }

    System.out.println(last);
  }
}
