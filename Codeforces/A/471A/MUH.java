//471A
import java.util.Scanner;

public class MUH
{
  public static String animal(int [] sticks)
  {
    if(fourSticks(sticks))
    {
      int [] other = getOther(sticks);
      if(other[0] == other[1])
        return "Elephant";
      else
        return "Bear";
    }
    else
      return "Alien";
  }

  public static int[] getOther(int[] sticks)
  {
    int [] other = new int[2];
    int c = 1;
    for(int i = 0 ; i < sticks.length ; i++)
    {
      for(int j = 0 ; j < sticks.length ; j++)
      {
        if(j != i)
        {
          if(sticks[i] == sticks[j])
            c++;
        }
      }
      if(c >= 4)
      {
        int b = 0 ;
        for(int a = 0 ; a < sticks.length ; a++)
        {
          if(sticks[i] != sticks[a])
          {
            other[b] = sticks[a];
            b++;
          }
        }
        return other;
      }
      else
        c = 1 ;
    }
    return other;
  }

  public static boolean fourSticks(int [] sticks)
  {
    int c = 1;
    for(int i = 0 ; i < sticks.length ; i++)
    {
      for(int j = 0 ; j < sticks.length ; j++)
      {
        if(j != i)
        {
          if(sticks[i] == sticks[j])
            c++;
        }
      }
      if(c >= 4)
        return true;
      else
        c = 1 ;
    }
    return false;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int [] sticks = new int[6];
    for(int i = 0 ; i < 6 ; i++)
       sticks[i] = sc.nextInt();
    System.out.println(animal(sticks));
  }
}
