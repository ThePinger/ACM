
import java.io.*;
import java.util.*;

public class BearCards
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    TreeMap <Integer,Integer> n = new TreeMap<Integer,Integer>();
    int sum  = 0;
    for(int i = 0 ; i < s.length ; i++)
    {
       int tmp = Integer.parseInt(s[i]);
       if(n.containsKey(tmp))
         n.put(tmp , n.get(tmp)+1);
       else
         n.put(tmp , 1);
       sum += tmp;
    }
      ArrayList <Integer> arr = new ArrayList<Integer>();
      for(int i = 0 ; i < s.length ; i++)
      {
        int tmp = Integer.parseInt(s[i]);
        int tmpSum = sum;
        if(!n.containsKey(tmp))
          continue;
        int v = n.get(tmp);
        if(v == 2)
        {
          tmpSum = tmpSum - (tmp*2);
          arr.add(tmpSum);
          n.remove(tmp);
        }
        else if(v >= 3)
        {
          tmpSum = tmpSum - (tmp*3);
          arr.add(tmpSum);
          n.remove(tmp);
        }
      }
      if(arr.size() > 0)
      {
        Collections.sort(arr);
        System.out.println(arr.get(0));
      }
      else
        System.out.println(sum);
  }
}
