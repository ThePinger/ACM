//149A
import java.util.Scanner ;
import java.util.Arrays ;
public class BusinessTrip
{
  public static int min(int k , int [] a , int sum)
  {
    if(sum < k)
      return -1 ;
    else if ( k == 0)
      return k ;
    else
    {
      Arrays.sort(a);
      int m = 0 ;
      int c = 0 ;
      for(int j = 11 ; j >=0 && c < k ; j--)
      {
        m++;
        c = c + a[j];
      }
      return m ;
    }
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int [] a = new int[12];
    int sum = 0 ;
    for(int i = 0 ; i < 12 ; i++)
    {
       a[i] = sc.nextInt();
       sum = sum + a[i];
    }
    System.out.println(min(k,a,sum));
  }
}
