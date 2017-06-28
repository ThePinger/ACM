//581A
import java.util.Scanner;

public class Socks
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int red = sc.nextInt();
    int blu = sc.nextInt();
    boolean flag = true;
    int mix = 0;
    int sam = 0;
    while(flag)
    {
      if(red > 0 && blu > 0)
      {
        red--;
        blu--;
        mix++;
      }
      else if(red > 1 || blu > 1)
      {
        if(red > 1)
          red -= 2;
        else if(blu > 1)
          blu -= 2;
        sam++;
      }
      else
        flag = false;
    }
    System.out.println(mix + " " + sam);
  }
}
