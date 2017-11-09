
import java.util.*;

public class Buttons
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int i = 0;
    int sum = 0;
    while(n > 0)
    {
      if(i == 0)
        sum += n;
      else
        sum += (n*i);
      i++;
      n--;
    }
    System.out.println(sum);
  }
}
