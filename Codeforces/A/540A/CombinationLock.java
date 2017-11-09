
import java.util.*;

public class CombinationLock
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int disks = sc.nextInt();
    char[] cur = sc.next().toCharArray();
    char[] lock = sc.next().toCharArray();
    int moves = 0;
    for(int i = 0 ; i < disks ; i++)
    {
      int tmpCur = Character.getNumericValue(cur[i]);
      int tmpNex = Character.getNumericValue(lock[i]);
      int absDiff = Math.abs(tmpNex - tmpCur);
      if(absDiff > 5)
        moves += (10 - absDiff);
      else
        moves += absDiff;
    }
    System.out.println(moves);
  }
}
