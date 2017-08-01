//68A
//Irrational problem
//Math
import java.util.*;

public class Irrational
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int[] nums = new int[4];
    for(int i = 0 ; i < 4 ; i++)
      nums[i] = sc.nextInt();
    Arrays.sort(nums);
    int min = sc.nextInt();
    int max = sc.nextInt();
    if(min >= nums[0])
      System.out.println(0);
    else
    {
      if(max < nums[0])
        System.out.println(max - min + 1);
      else
        System.out.println(nums[0] - min);
    }
  }
}
