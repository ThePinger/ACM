//158A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class NextRound
{

  public static int participants(String[] line , int minScore)
  {
    int c = 0 ;
    for(int i = 0 ; i < line.length ; i++)
    {
      int a = Integer.parseInt(line[i]);
      if(a >= minScore && a > 0)
        c++;
    }
    return c;
  }

  public static void main(String[] args) throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr, 16 * 1024);
    String[] line0 = br.readLine().split(" ");
    int a = Integer.parseInt(line0[0]);
    int b = Integer.parseInt(line0[1]);
    String [] line1 = br.readLine().split(" ");
    int score = Integer.parseInt(line1[b-1]);
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(participants(line1 , score));
    pw.close();

  }
}
