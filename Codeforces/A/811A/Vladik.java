import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Vladik
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    long vladik = Long.parseLong(s[0]);
    long valera = Long.parseLong(s[1]);
    long preV = 1;
    while(vladik >= 0 && valera >= 0)
    {
      if(preV % 2 != 0)
      {
        vladik -= preV;
        preV++;
      }
      else
      {
        valera -= preV;
        preV++;
      }
    }
    if(vladik < 0 )
      System.out.println("Vladik");
    else
      System.out.println("Valera");
  }
}
