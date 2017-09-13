//339A
//Helpful Maths

import java.io.*;
import java.util.*;

public class HelpfulMath
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0 ; i < s.length() ;i++)
      if(s.charAt(i) != '+')
        pq.add(Character.getNumericValue(s.charAt(i)));
    int k = 1;
    while(!pq.isEmpty())
    {
      if(k == 1)
       System.out.print(pq.remove());
      else
       System.out.print("+"+pq.remove());
      k++;
    }
  }
}
