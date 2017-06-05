//110A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LuckyNumber
{
  public static String lucky(String line)
  {
    int lucky = 0;
    for(int i = 0 ; i < line.length() ; i++)
    {
      if(line.charAt(i) == '4' || line.charAt(i) == '7')
        lucky++;
    }
    if(lucky == 7 || lucky == 4)
      return "YES";
    else
      return "NO";
  }

  public static void main(String[] args) throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr, 16 * 1024);
    String line0 = br.readLine();
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(lucky(line0));
    pw.close();
  }
}
