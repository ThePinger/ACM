//621
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
    String s ;
    int length;
    for(int i = 0 ; i < n ; i++)
    {
      s = br.readLine();
      length = s.length();
      if(length == 1 || length == 2)
        System.out.println('+');
      else if(s.charAt(length - 1) == '5' && s.charAt(length - 2) == '3')
        System.out.println('-');
      else if(s.charAt(0) == '9')
        System.out.println('*');
      else
        System.out.println('?');
    }
  }
}
