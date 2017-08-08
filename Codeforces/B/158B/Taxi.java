//158B
//Taxi
//Greedy
import java.util.*;
public class Taxi
{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    TreeMap<Integer,Integer> map = new TreeMap<>();
    int taxi = 0;
    for(int i = 0 ; i < n ;i++)
    {
      int num = sc.nextInt();
      if(num != 4)
      {
       if(map.containsKey(num))
         map.put(num , map.get(num) + 1);
       else
         map.put(num , 1);
      }
      else
       taxi++;
    }
    if(map.containsKey(3))
    {
      int value = map.get(3);
      int one = 0;
      if(map.containsKey(1))
        one = map.get(1);
      if(one > value)
        map.put(1,one - value);
      else
        map.remove(1);
      taxi += value;
    }
    if(map.containsKey(2))
    {
      int value = map.get(2);
      int one = 0;
      if(value % 2 == 0)
        taxi += value / 2;
      else
      {
        taxi += value / 2;
        taxi++;
        if(map.containsKey(1))
          one = map.get(1);
        if(one >= 2)
          map.put(1,one - 2);
        else
          map.remove(1);
      }
    }
    if(map.containsKey(1))
    {
      int value = map.get(1);
      if(value % 4 != 0)
        taxi ++;
      taxi += value / 4;
    }
    System.out.println(taxi);
  }
}
