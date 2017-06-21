//510A
import java.util.Scanner;

public class Snake
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    char next = 'r';
    boolean f = true;
    boolean flag = true;
    for(int i = 0 ; i < r ; i++)
    {
      for(int j = 0 ; j < c ; j++)
      {
        if(f && flag)
          System.out.print('#');
        else if(f && !flag)
        {
          if(j == 0)
            System.out.print('#');
          else
            System.out.print('.');
        }
        else
        {
          if(j+1 == c)
           System.out.print('#');
          else
           System.out.print('.');
        }
      }
      if(f && flag)
      {
        if(next == 'r')
        {
          flag = false;
          f = false;
          next = 'l';
        }
        else
        {
          flag = false;
          next = 'r';
        }
      }
      else
      {
        flag = true;
        f = true;
      }
      System.out.println("");
    }
  }
}
