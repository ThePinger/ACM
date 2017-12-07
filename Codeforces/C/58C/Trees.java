//58C
//Trees
//BruteForce
import java.util.*;

public class Trees
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] trees = new int[n + 1];
    int max = 0;

    for(int i = 1 ; i < n + 1 ; i++)
    {
       trees[i] = sc.nextInt();
       max = Math.max(max, trees[i]);
    }

    int size;
    if(max < n) size = n;
    else size = max;

    int[] good = new int[size];
    int j = n;
    for(int i = 1; i < j ; i++)
    {
      good[Math.abs(trees[i] - i)]++;
      good[Math.abs(trees[j] - i)]++;
      j--;
    }

    if(n % 2 != 0) good[Math.abs(trees[j] - j)]++;

    int changes = 0;
    for(int i = 0; i < good.length ; i++)
       changes = Math.max(good[i], changes);

    int tmpMax = 0;
    if(n > 1 && ((trees[1] == 1 && trees[2] == 1) || (trees[n] == 1 && trees[n-1] == 1)) && good[0] != changes)
       for(int i = 0 ; i < good.length ; i++)
          if(good[i] != changes) tmpMax = Math.max(good[i], tmpMax);

    if(tmpMax != 0) changes = tmpMax;

    System.out.println(n - changes);
  }
}
