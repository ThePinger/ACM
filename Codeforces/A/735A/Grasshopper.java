import java.util.*;

public class Grasshopper
{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int jump = sc.nextInt();
    int g = -1;
    int t = -1;
    int c = 0;
    String s = sc.next();
    for(int i = 0 ; i < n ; i++)
    {
      if(s.charAt(i) == 'T')
      {
        t = i;
        c++;
      }
      else if(s.charAt(i) == 'G')
      {
        g = i;
        c++;
      }
      if(c == 2)
        break;
    }
    boolean f =true;
    if(t < g)
    {
      for(int i = g ; i >= t ; i-=jump)
      {
        if(t > i-jump || s.charAt(i-jump) == '#')
        {
          System.out.println("NO");
          f = false;
          break;
        }
        else if(s.charAt(i-jump) == 'T')
          break;
      }
      if(f)
       System.out.println("YES");
    }
    else
    {
      for(int i = g ; i <= t ; i+=jump)
      {
        if(t < i+jump || s.charAt(i+jump) == '#')
        {
          System.out.println("NO");
          f = false;
          break;
        }
        else if(s.charAt(i+jump) == 'T')
          break;
      }
      if(f)
        System.out.println("YES");
    }
  }
}
