//466A
import java.util.Scanner;

public class Travel
{

  public static int cheap(int required , int packageT , int single , int packagePrice)
  {
    int sin = 0 ;
    int pack = 0;
    int mix = 0 ;
    int tmp = required;
    sin = single * required;
    while(required > 0)
    {
      pack += packagePrice;
      required = required - packageT;
    }
    required = tmp;
    while(required > 0)
    {
      if(required > packageT)
      {
        mix += packagePrice;
        required = required - packageT;
      }
      else
      {
        if(required*single < packagePrice)
          mix += required*single;
        else
          mix += packagePrice;
        required = 0;
      }
    }
    if(sin < pack && sin < mix)
      return sin;
    else if(pack < sin && pack < mix)
      return pack;
    else
      return mix;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int required = sc.nextInt();
    int packageT = sc.nextInt();
    int single = sc.nextInt();
    int packagePrice = sc.nextInt();
    System.out.println(cheap(required , packageT , single , packagePrice));
  }
}
