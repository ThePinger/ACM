//112A
//Petya and  Strings

import java.io.*;

public class Strings
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String a = br.readLine().toLowerCase();
    String b = br.readLine().toLowerCase();
    for(int i = 0 ; i < a.length() ; i++)
    {
      if(a.charAt(i) > b.charAt(i))
      {
        System.out.println(1);
        return;
      }
      else if(a.charAt(i) < b.charAt(i))
      {
        System.out.println(-1);
        return;
      }
    }
    System.out.println(0);
  }
}
