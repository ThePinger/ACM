import java.io.*;
import java.util.*;

public class MainB
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    double xr = Math.pow(sc.nextDouble(),2);
    double yr = Math.pow(sc.nextDouble(),2);
    double xw = Math.pow(sc.nextDouble(),2);
    double yw = Math.pow(sc.nextDouble(),2);
    double russo = Math.sqrt(xr+yr);
    double wil = Math.sqrt(xw+yw);
    if(russo == wil)
      System.out.println("Empate");
    else if(russo < wil)
      System.out.println("Russo");
    else
      System.out.println("Wil");
  }
}
