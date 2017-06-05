//282A
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Bit
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 16 * 1024);
    int n = Integer.parseInt(br.readLine());
    int x = 0;
    for(int i = 0 ; i < n ; i++)
    {
      String s = br.readLine();
      if(s.charAt(0) == 'X')
      {
        if(s.charAt(1) == '+')
          x++;
        else
          x--;
      }
      else
      {
        if(s.charAt(0) == '+')
           x++;
        else
           x--;
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(x);
    pw.close();
  }
}
