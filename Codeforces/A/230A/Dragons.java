//230A
import java.util.Scanner ;
import java.util.Arrays;
public class Dragons
{
  public static void sort(int [] x , int [] y)
  {
    for(int i = 0 ; i<x.length ; i++)
    {
      for(int j = 0 ; j<x.length ; j++)
      {
        if(x[i] <= x[j])
        {
          int tmp = x[i] ;
          x[i] = x[j] ;
          x[j] = tmp ;
          int c = y[i] ;
          y[i] = y[j] ;
          y[j] = c ;
        }
      }
    }
  }
  public static void defeat(int s , int n , int[] x , int[]y)
  {
    sort(x,y);
    int i =0 ;
    boolean  f = true;
    if(x[0] > s)
      System.out.println("NO");
    else
    {
      while(f && i<x.length)
      {
        if(s > x[i] )
          s = s + y[i];
        else
          f = false ;
        i++;
      }
      if(f)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int s = sc.nextInt();
    int n = sc.nextInt();
    int [] x = new int[n];
    int [] y = new int[n];
    int i = 0 ;
    while(i < n)
    {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      i++;
    }
    defeat(s , n , x , y);
  }
}
