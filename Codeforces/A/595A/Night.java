import java.util.*;
import java.io.*;
public class Night
{
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int floors = Integer.parseInt(s[0]);
    int flats = Integer.parseInt(s[1]);
    int c = 0;
    for(int i = 0 ; i < floors ; i++)
    {
      s = br.readLine().split(" ");
      boolean vis = false;
      for(int j = 0 ; j < s.length ; j++)
      {
        if(s[j].equals("1"))
        {
          if(!vis)
          {
           c++;
           vis = true;
          }
        }
        if(j%2 != 0)
         vis = false;
      }
    }
    System.out.println(c);
  }
}
