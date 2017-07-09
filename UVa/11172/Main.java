//11172]
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    int n = Integer.parseInt(br.readLine());
    long a ;
    long b ;
    String[] s;
    for(int i = 0 ; i < n ; i++)
    {
      s = br.readLine().split(" ");
      a = Long.parseLong(s[0]);
      b = Long.parseLong(s[1]);
      if(a > b)
        System.out.println('>');
      else if (a < b)
        System.out.println('<');
      else
        System.out.println('=');
    }
  }
}
