//237A
import java.util.Scanner ;
public class Cash
{
  public static int cash(long [] t)
  {
    int n = 1 ;
    int c = 1 ;
    int x = 0 ;
    boolean f = false ;
    for(int i =0 ; i < t.length-1 ; i++)
    {
      if(t[i] == t[i+1] && f != true)
      {
        n++;
        c++;
        x = 1 ;
      }
      else if (t[i] != t[i+1] && x == 1)
      {
        f = true ;
        c = n ;
      }
      else if (t[i] == t[i+1])
      {
        c--;
        if(c < 1)
        {
          n++;
          f = false ;
        }
      }


    }
    return n ;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int customers = sc.nextInt();
    long [] t = new long [customers] ;
     for(int i = 0 ; i < t.length ; i++)
        t[i] = (sc.nextInt()*3600) + (sc.nextInt()*60) ;
     System.out.println(cash(t));
  }
}
