//133A
//HQ9+

import java.io.*;

public class HQ9
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    for(int i = 0 ; i < s.length() ; i++)
       if(s.charAt(i) == 'H' || s.charAt(i) == 'Q' || s.charAt(i) == '9')
       {
         System.out.println("YES");
         return;
       }
    System.out.println("NO");
  }
}
