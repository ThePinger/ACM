//82A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Cola
{
  public static void main(String[] args) throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16);
    int n = Integer.parseInt(br.readLine());
    PrintWriter pw = new PrintWriter(System.out);
    int s = 1;
    int l = 1;
    int p = 1;
    int r = 1;
    int h = 1;
    String curr = "Sheldon";
    String last = "";
    int i = 0;
     while( i < n)
      {
        switch(curr)
        {
          case "Sheldon": i = i + s ; s = s * 2;  curr = "Leonard";last = "Sheldon";
                         break;
          case "Leonard": i = i + l ; l = l * 2; curr = "Penny" ; last = "Leonard";
                         break;
          case "Penny"  : i = i + p ; p = p * 2;  curr = "Rajesh"; last = "Penny";
                         break;
          case "Rajesh" : i = i + r ; r = r * 2; curr = "Howard"; last = "Rajesh";
                         break;
          case "Howard" : i = i + h ; h = h * 2; curr = "Sheldon"; last = "Howard";
                         break;
        }
      }
    pw.println(last);
    pw.close();
    }
}
