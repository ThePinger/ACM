//546A
import java.util.Scanner ;
public class SoldierBananas
{
  public static int dollars(int k , int d , int n)
  {
    int sum = 0 ;
    for(int i = 1 ; i <= n ; i++)
       sum = sum + (i*k);
    if(sum > d)
      return sum - d ;
    else
      return 0 ;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int bcost = sc.nextInt();
    int d = sc.nextInt();
    int bnum = sc.nextInt();
    System.out.println(dollars(bcost , d , bnum));
  }
}
