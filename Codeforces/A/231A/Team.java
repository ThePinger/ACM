//231A
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Team
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 16 * 1024);
    int n = Integer.parseInt(br.readLine());
    int ans = 0;
    for(int i = 0 ; i < n ; i++)
    {
      String [] s = br.readLine().split(" ");
      int c = 0 ;
      for(int j = 0 ; j < 3 ; j++)
      {
        if(s[j].equals("1"))
          c++;
      }
      if(c >= 2)
        ans++;
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(ans);
    pw.close();
  }
}
