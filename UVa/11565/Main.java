//11565
//Simple Equations
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class  Main
{

  public static boolean right(int x , int y , int z , int a , int b , int c)
  {
    if(x + y + z != a)
       return false;
    if(x*y*z != b)
       return false;
    if((x*x)+(y*y)+(z*z) != c)
       return false;
    return true;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < n ;i++)
    {
      String[] s = br.readLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int b = Integer.parseInt(s[1]);
      int c = Integer.parseInt(s[2]);
      boolean flag1 = false;
      loop : for(int x = -101 ; x < 101 ; x++)
      {
        for(int y = x+1 ; y < 101 ; y++)
        {
          int z = a - x - y;
          if(z == x || z == y)
            continue;
          if(right(x , y , z ,a , b, c))
          {
            System.out.println(x + " " + y + " " + z);
            flag1 = true;
            break loop;
          }
        }
      }
      if(!flag1)
        System.out.println("No solution.");
    }
  }
}
