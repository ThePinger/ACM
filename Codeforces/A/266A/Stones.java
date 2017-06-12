//266A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Stones
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024*16);
    int n = Integer.parseInt(br.readLine());
    String s  = br.readLine();
    int c = 0;
    for(int i = 0 ; i < n-1 ; i++)
    {
      if(s.charAt(i) == s.charAt(i+1))
        c++;
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(c);
    pw.close();
  }
}
