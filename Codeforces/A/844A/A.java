
import java.io.*;
import java.util.*;

public class A
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int dist = sc.nextInt();
    if(dist > s.length())
      System.out.println("impossible");
    else
    {
      TreeSet <Character> ts = new TreeSet<>();
      for(int i = 0 ; i < s.length() ; i++)
      {
        char tmp = s.charAt(i);
        ts.add(tmp);
      }
      if(dist - ts.size() > 0)
        System.out.println(Math.abs(dist - ts.size()));
      else
        System.out.println(0);
    }
  }
}
