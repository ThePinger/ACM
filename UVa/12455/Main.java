//12455
//Bars
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
  static int size;
  static String[] s;
  static boolean flag;

  public static void enough(int i , int m)
  {
    if(m == size || i == s.length)
    {
      if(m == size)
        flag = true;
      return;
    }
    enough(i+1 , m + Integer.parseInt(s[i]));
    enough(i+1 , m);
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < n ;i++)
    {
      size = Integer.parseInt(br.readLine());
      br.readLine();
      s = br.readLine().split(" ");
      flag = false;
      enough(0,0);
      if(flag)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
}
