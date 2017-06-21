//344A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Magnets
{

  public static int seq(String[] m)
  {
    int c = 1 ;
    String pre = m[0];
    for(int i = 1 ; i < m.length ; i++)
    {
      if(!m[i].equals(pre))
      {
        c++;
        pre = m[i];
      }
    }
    return c;
  }

  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16);
    int n = Integer.parseInt(br.readLine());
    String[] m = new String[n];
    for(int i = 0 ; i < n ; i++)
       m[i] = br.readLine();
    System.out.println(seq(m));
  }
}
