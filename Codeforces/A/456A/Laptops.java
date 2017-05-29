//456A
import java.util.Scanner;
public class Laptops
{
  public static String ans(long n , long[][]info)
  {
    boolean f = false;
    long [] max = new long[2];
    max[0] = info[0][0];
    max[1] = info[0][1];
    for(int i = 0 ; i < n-1 ; i++)
    {
      long price = info[i][0];
      long rating = info[i][1];
      long price2 = info[i+1][0];
      long rating2 = info[i+1][1];
      //Compare between prices
      if(price > price2)
      {
        if(rating2 > rating)
            f = true;
      }
      else if(price2 > price)
      {
        if(rating > rating2)
            f = true;
      }
      //Compare with max
      if(max[0] > price2 && max[1] < rating2)
        f = true;
      else if(max[0] > price && max[1] < rating)
        f = true;
      if(max[0] < price2 && max[1] > rating2)
        f = true;
      else if(max[0] < price && max[1] > rating)
        f = true;
      max = updateMax(max , info[i][0] , info[i][1]);
    }
    if(f)
      return "Happy Alex";
    else
      return "Poor Alex";
  }

  public static long [] updateMax(long[] max , long p , long r)
  {
    if(max[0] < p)
    {
       max[0] = p;
       max[1] = r;
    }
    return max;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long [][] info = new long[n][2];
    for(int i = 0 ; i < n ;i++)
    {
       info[i][0] = sc.nextInt();
       info[i][1] = sc.nextInt();
    }
    System.out.println(ans(n , info));
  }
}
