//11044
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
    String[] s;
    int r ;
    int c ;
    int sonarsF;
    int sonars;
    for(int i = 0 ; i < n ; i++)
    {
      s = br.readLine().split(" ");
      r = Integer.parseInt(s[0]);
      c = Integer.parseInt(s[1]);
      sonars = 0;
      sonarsF = 0;
      while(c > 2)
      {
        c = c - 3;
        sonarsF++;
      }
      while(r > 2)
      {
        r = r - 3;
        sonars = sonars + sonarsF;
      }
      System.out.println(sonars);
    }
  }
}
