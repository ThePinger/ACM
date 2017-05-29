//570A
import java.util.Scanner ;
import java.util.Arrays ;
public class Elections
{
  public static int citywinner(int [] x)
  {
    int max = 1 ;
    for(int i = 0 ; i< x.length ; i++)
    {
      if(x[i] > x[max-1] )
        max = i+1 ;
    }
    return max -1  ;
  }
  public static int winner ( int [] x )
  {
    int winner = 1 ;
    for(int i = 0 ; i < x.length ; i++)
    {
      if(x[i] > x[winner-1])
        winner =  i +1 ;
    }
    return winner  ;
  }

  public static void main(String [] args)
  {
    Scanner sc = new Scanner (System.in) ;
    int candidates = sc.nextInt();
    int cities = sc.nextInt();
    int [] w = new int [cities] ;
    int [] f = new int [candidates] ;
    for(int j = 0 ; j < w.length ; j++)
    {
      int [] c = new int [candidates] ;
      for(int i = 0 ; i < c.length ; i++)
         c[i] = sc.nextInt() ;
      w[j] = citywinner(c) ;
      f[w[j]] = f[w[j]] + 1 ;
    }
    System.out.println(winner(f)) ;
  }
}
