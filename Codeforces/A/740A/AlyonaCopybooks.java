//740A
import java.util.Scanner;
public class AlyonaCopybooks
{
  public static long minRubles(long n , long a , long b , long c)
  {
    long ia = b+c ;
    long ha = c*3 ;
    long jb = a*6 ;
    long lb = c*2 ;
    long mc = a*7 ;
    long nc = (b*2) + (a*3);
    long k = 0 ;
    if(n%4 == 0)
      return 0 ;
    else
    {
      while((n+k)%4 != 0)
      {
        k++;
      }
    }
      long e = b +a ;
      long f = a*2 ;
      long g = a *3;
  if(k ==1)
  {
    if( a <= ia && a <= ha)
      return a ;
    else if (ia <= a && ia <= ha)
      return ia ;
    else
      return ha ;
  }
  else if(k == 2)
  {
      if( f >= b && jb >= b && lb >= b )
        return b ;
      else if ( b >= f && jb >= f && lb >= f)
        return f ;
      else if(b >= jb && f >= jb && lb >= jb)
        return jb ;
      else
        return lb ;
  }
  else
  {
      if(e >= c && g >= c && mc >=c && nc >=c)
        return c ;
      else
      {
        if( e >= g && mc >= g && nc >= g)
          return g ;
        else if(mc >= e && nc >= e && g >= e)
          return e ;
        else if (nc >= mc && e >= mc && g >= mc)
          return mc ;
        else
          return nc ;
      }
  }
  }
  public static void main(String[]args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    System.out.println(minRubles(n,a,b,c));
  }
}
