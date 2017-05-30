//349A
import java.util.Scanner;

public class CinemaLine
{
  public static String enough(int [] money)
  {
    long money25 = 0 ;
    long money50 = 0 ;
    long money100 = 0 ;
    for(int i = 0 ; i < money.length ; i++)
    {
      if(money[i] == 25)
        money25++;
      else if(money[i] == 50)
      {
        if(money25 == 0)
          return "NO";
        else
        {
          money25--;
          money50++;
        }
      }
      else
      {
        if((money25 < 3  && money50 == 0) ||(money25 == 0))
          return "NO";
        else
        {
          if(money50 == 0)
            money25 = money25 - 3;
          else
          {
            money25--;
            money50--;
          }
          money100++;
        }
      }
    }
    return "YES";
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int line = sc.nextInt();
    int [] money = new int[line];
    for(int i = 0 ; i < line ; i++)
       money[i] = sc.nextInt();
    System.out.println(enough(money));
  }
}
