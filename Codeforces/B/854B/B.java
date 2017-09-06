
import java.io.*;
import java.util.*;
public class B
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int apart = sc.nextInt();
    int inhab = sc.nextInt();
    if(inhab == 0 || apart == inhab)
      System.out.println(0 + " " + 0);
    else if(inhab == 1)
      if(apart >= 3)
        System.out.println(1 + " " + 2);
      else
        System.out.println(1 + " " + 1);
    else if(inhab == 2)
      if(apart >= 6)
        System.out.println(1 + " " + 4);
      else
        System.out.println(1 + " " + (apart - inhab));
    else
      if(inhab*2 <= apart - inhab)
        System.out.println(1 + " " + (inhab*2));
      else
        System.out.println(1 + " " + (apart - inhab));
  }
}
