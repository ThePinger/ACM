//Lucky
import java.io.*;

public class Lucky
{

  public static boolean lucky(int n)
  {
    String s = n + "";
    for(int i = 0 ; i < s.length() ; i++)
    {
      if(s.charAt(i) != '4' && s.charAt(i) != '7')
        return false;
    }
    return true;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if(lucky(n))
      System.out.println("YES");
    else
    {
      boolean flag = false;
      loop : for(int i = n - 1 ; i > 0 ; i--)
      {
        if(n%i == 0)
        {
          if(lucky(i))
          {
           flag = true;
           break loop;
          }
        }
      }
      if(flag)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
}
