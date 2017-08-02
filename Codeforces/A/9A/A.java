
import java.io.*;
import java.util.*;

public class A
{

  public static int gcd(int poss , int a)
  {
    for(int i = poss ; i > 0 ; i --)
    {
      if(poss%i == 0 && a%i == 0)
        return i;
    }
    return 1;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int y = sc.nextInt();
    int w = sc.nextInt();
    if(y > w)
    {
      int poss = 7 - y ;
      int gcd = gcd(poss,6);
      System.out.println(poss/gcd +"/"+ 6/gcd);
    }
    else
    {
      int poss = 7 - w;
      int gcd = gcd(poss,6);
      System.out.println(poss/gcd +"/"+ 6/gcd);      
    }
  }
}
