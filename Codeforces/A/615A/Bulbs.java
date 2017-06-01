//615A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Bulbs
{
  public static void main(String[] args) throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr, 16 * 1024);
    String[] line0 = br.readLine().split(" ");
    int buttons = Integer.parseInt(line0[0]);
    int bulbs = Integer.parseInt(line0[1]);
    ArrayList <Integer> light = new ArrayList <Integer>();
    for(int i = 0 ; i < buttons ; i++)
    {
      String[] line1 = br.readLine().split(" ");
      int n = Integer.parseInt(line1[0]);
      for(int j = 1 ; j <= n ; j++)
      {
         int a = Integer.parseInt(line1[j]);
         if(!light.contains(a))
           light.add(a);
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    if(light.size() == bulbs)
      pw.println("YES");
    else
      pw.println("NO");
    pw.close();
  }
}
