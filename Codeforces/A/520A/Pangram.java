//520A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pangram
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine().toLowerCase();
    ArrayList<Character> ch = new ArrayList<Character>();
    if(n < 26)
      System.out.println("NO");
    else
    {
      for(int i  = 0 ; i < n ; i++)
      {
        if(!ch.contains(s.charAt(i)))
          ch.add(s.charAt(i));
      }
      if(ch.size() >= 26)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
}
