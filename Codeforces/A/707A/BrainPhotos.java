//707A

import java.io.*;
import java.util.*;
public class BrainPhotos
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int rows    = Integer.parseInt(st.nextToken());
    int columns = Integer.parseInt(st.nextToken());

    boolean color = false;
    loop :for(int i = 0 ; i < rows ; i++)
    {
      st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens())
      {
        String s = st.nextToken();
        if(!s.equals("W") && !s.equals("B") && !s.equals("G")){ color = true; break loop;}
      }
    }

    if(color) System.out.println("#Color");
    else System.out.println("#Black&White");
  }
}
