import java.io.*;
import java.util.StringTokenizer;
public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while(t-->0)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = 0;
      int f = 0;
      while(st.hasMoreTokens())
      {
        String s = st.nextToken();
        if(s.charAt(0) == 'M')
          m++;
        else
          f++;
        if(s.charAt(1) == 'M')
          m++;
        else
          f++;
      }
      if(m == f && m + f != 2)
        System.out.println("LOOP");
      else
        System.out.println("NO LOOP");
    }
  }
}
