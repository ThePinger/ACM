//11799
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    int t = Integer.parseInt(br.readLine());
    int max ;
    int cur ;
    String[] s;
    for(int i = 0 ; i < t ; i++)
    {
      s = br.readLine().split(" ");
      max = Integer.parseInt(s[1]);
      for(int c = 2 ; c < s.length ; c++ )
      {
        cur = Integer.parseInt(s[c]);
        if(cur > max)
          max = cur;
      }
      System.out.println("Case " + (i+1) + ": " + max);
    }
  }
}
