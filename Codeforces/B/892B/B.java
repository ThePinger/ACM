
import java.util.*;

public class B
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n+1];
    for(int i = 1 ; i < n + 1 ; i++)
      arr[i] = sc.nextInt();

    int alive = n;
    int lastkilled = n + 1;
    for(int i = n ; i > 1 ; i--)
    {
      int tmp = i - arr[i];
      if(arr[i] >= i)
      {
        if(lastkilled < i)
          alive -= (lastkilled - 1);
        else
          alive -= (i - 1);
        break;
      }
      else
      {
        if(tmp < lastkilled)
        {
          if(lastkilled < i)
            alive -= (arr[i] - (i - lastkilled));
          else
            alive -= arr[i];
          lastkilled = tmp ;
        }
      }
    }
    System.out.println(alive);
  }
}
