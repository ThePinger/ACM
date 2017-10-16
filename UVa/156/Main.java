
import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> words = new ArrayList<>();
    loop : while(true)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      while (st.hasMoreTokens())
      {
        String s = st.nextToken();
        if(s.equals("#"))
           break loop;
        else
          words.add(s);
      }
    }
    PriorityQueue <String> pq = new PriorityQueue<>();
    for(int i = 0 ; i < words.size() ; i++)
    {
      int[] occur = new int[26];
      for(int j = 0 ; j < words.get(i).length() ; j++)
        occur[Character.toLowerCase(words.get(i).charAt(j)) - 97]++;
      boolean ff = true;
      for(int c = i + 1  ; c < words.size() ; c++)
      {
        boolean f = true;
        int[] occur2 = new int[26];
        for(int j = 0 ; j < words.get(c).length() ; j++)
          occur2[Character.toLowerCase(words.get(c).charAt(j)) - 97]++;
        for(int j = 0 ; j < 26 ; j++)
          if(occur[j] != occur2[j])
            f = false;
        if(f)
        {
          words.remove(c);
          c--;
          ff = false;
        }
      }
      if(ff)
        pq.add(words.get(i));
    }
    //System.out.println();
    while(!pq.isEmpty())
      System.out.println(pq.remove());
  }
}
