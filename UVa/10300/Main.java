//10300
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
public class Main
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    PrintWriter pw = new PrintWriter(System.out);
    int n = Integer.parseInt(br.readLine());
    int f ;
    long sum ;
    long size;
    long enviroment;
    String[] s;
    for(int i = 0 ; i < n ; i++)
    {
      sum = 0;
      f = Integer.parseInt(br.readLine());
      for (int j = 0; j < f ; j++)
      {
        s = br.readLine().split(" ");
        size = Long.parseLong(s[0]);
        enviroment = Long.parseLong(s[2]);
        sum = sum + (size * enviroment);
      }
      pw.println(sum);
    }
    pw.close();
  }
}
