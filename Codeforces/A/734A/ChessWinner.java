//734A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ChessWinner
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    int a = 0;
    int d = 0;
    for(int i = 0 ; i < n ; i++)
    {
      if(s.charAt(i) == 'A')
        a++;
      else
        d++;
    }
    if(a > d)
      System.out.println("Anton");
    else if(d > a)
      System.out.println("Danik");
    else
      System.out.println("Friendship");
  }
}
