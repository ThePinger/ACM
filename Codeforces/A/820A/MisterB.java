import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MisterB
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int c = Integer.parseInt(s[0]);
    int vo = Integer.parseInt(s[1]);
    int v1 = Integer.parseInt(s[2]);
    int a = Integer.parseInt(s[3]);
    int l = Integer.parseInt(s[4]);
    int days = 0;
    int maxD ;
    while(c > 0)
    {

      if(days == 0 )
        c = c - vo;
      else
      {
        maxD = vo + (a*days);
        if(maxD > v1)
          c = c - v1 + l;
        else
          c = c - maxD + l;
      }
      days++;
    }
    System.out.println(days);
  }
}
