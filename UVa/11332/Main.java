//11332
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    boolean f = true;
    String s ;
    int sum;
    while(f)
    {
      s = br.readLine();
      if(s.equals("0"))
        f = false;
      else
      {
        while(s.length() != 1)
        {
          sum = 0;
          for(int i = 0 ; i < s.length() ; i++)
            sum = sum + Character.getNumericValue(s.charAt(i));
          s = sum + "";
        }
        System.out.println(s);
      }
    }
  }
}
