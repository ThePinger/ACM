//271A
import java.util.Scanner;
import java.io.PrintWriter;

public class BeautifulYear
{

  public static int getNextYear(int s)
  {
    String a ;
    boolean f = false;
    int counter = 0;
    while(!f)
    {
      s++;
      a = s + "";
      for(int j = 0 ; j < 4 ; j++)
      {
        for(int c = j + 1; c < 4 ; c++)
        {
          if(a.charAt(j) != a.charAt(c))
            counter++;
        }
      }
      if(counter == 6)
        f = true;
      counter = 0;
    }
    return s;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int s = sc.nextInt();
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(getNextYear(s));
    pw.close();
  }
}
