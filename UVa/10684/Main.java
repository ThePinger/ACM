//10684
//Jackpot
import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while(n != 0)
    {
      ArrayList <Integer> arr = new ArrayList<Integer>();
      for(int i = 0 ; i < n ; i++)
         arr.add(sc.nextInt());
      int maxStreak = 0;
      int tmp = 0;
      int total = 0;
      for(int j = 0 ; j < n ; j++)
      {
        if(tmp < 0)
          tmp = 0;
        if(arr.get(j) < 0)
        {
          if(tmp > maxStreak)
            maxStreak = tmp;
        }
        tmp += arr.get(j);
      }
      if(tmp > maxStreak)
        maxStreak = tmp;
      if(maxStreak == 0)
        System.out.println("Losing streak.");
      else
        System.out.println("The maximum winning streak is " + maxStreak + ".");
      n = sc.nextInt();
    }
  }
}
