import java.io.*;
import java.util.*;

public class Night
{
  public static void main(String[] args)throws IOException
  {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     TreeMap<Long , Integer> nums = new TreeMap<Long , Integer>();
     for(int i = 0; i < n ; i++)
     {
       long tmp = sc.nextLong();
       if(nums.containsKey(tmp))
         nums.put(tmp , nums.get(tmp)+1);
       else
         nums.put(tmp , 1);
      }
      if(n == 1 || n == 2 || nums.get(nums.lastKey()) == n)
        System.out.println(0);
      else
        System.out.println(n - nums.get(nums.firstKey()) - nums.get(nums.lastKey()));
  }
}
