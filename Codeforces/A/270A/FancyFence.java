//270A
import java.util.Scanner;

public class FancyFence
{
  public static void isPossible(int size , int [] angles)
  {
    for(int i = 0 ; i < size ; i++)
    {
      int x = 360 % (180 - angles[i]);
      if(x == 0)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] angles = new int[size];
    for(int i = 0 ; i < size ; i++)
      angles[i] = sc.nextInt();
    isPossible(size , angles);
  }
}
