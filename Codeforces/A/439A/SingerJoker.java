
import java.io.*;

public class SingerJoker
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int d = Integer.parseInt(s[1]);
    s = br.readLine().split(" ");
    int i = 0;
    int jokes = 0;
    boolean turn = true;
    loop : while(i != s.length)
    {
       if(turn)
       {
          d -= Integer.parseInt(s[i]);
          i++;
          turn = false;
       }
       else
       {
          d -= 10;
          jokes += 2;
          turn = true;
       }
    }
    while(d > 0)
    {
      if(d - 10 >= 0)
      {
        d -= 10;
        jokes += 2;
      }
      else if(d -5 >= 0)
      {
        d -= 5;
        jokes++;
      }
      else
        break;
    }
    if(d >= 0)
      System.out.println(jokes);
    else
      System.out.println(-1);
  }
}
