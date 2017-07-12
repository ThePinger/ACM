import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Bank
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    if(s.charAt(0) == '-')
    {
      char a = s.charAt(s.length()-1);
      char b = s.charAt(s.length()-2);
      int tmpA = Character.getNumericValue(a);
      int tmpB = Character.getNumericValue(b);
      if(tmpA > tmpB)
        s = s.substring(0,s.length()-1);
      else
        s = s.substring(0,s.length()-2) + a;
      if(s.equals("-0"))
        s = "0";
    }
    System.out.println(s);
  }
}
