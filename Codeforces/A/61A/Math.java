//61A
//Ultra fast Mathematician
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Math
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line0 = br.readLine();
    String line1 = br.readLine();
    String ans = "";
    for(int i = 0 ; i < line1.length() ; i++)
    {
      if(line1.charAt(i) == line0.charAt(i))
        ans = ans + '0';
      else
        ans = ans + '1';
    }
    System.out.println(ans);
  }
}
