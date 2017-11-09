
import java.util.*;
import java.text.DecimalFormat;

public class OrangePortion
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    double orange = 0;
    for(int i = 0 ; i < n ; i++)
      orange += (sc.nextDouble() / 100);

    DecimalFormat df = new DecimalFormat("#0.000000000000");
    System.out.println(df.format((orange / n) * 100));
  }
}
