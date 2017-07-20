//KIng MOves
import java.io.*;
import java.util.*;
public class King
{
  public static void main(String[] args)throws IOException
  {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String s = br.readLine();
     int a = 105 - (int) s.charAt(0);
     a = 9 - a;
     int b = Character.getNumericValue(s.charAt(1));
     int allowed = 8;
     boolean f = false;
     if(a == 8 || a == 1)
     {
       f = true;
       allowed -= 3;
     }
     if(b == 8 || b == 1)
     {
       if(f)
        allowed -= 2;
       else
        allowed -= 3;
     }
     System.out.println(allowed);
  }
}
