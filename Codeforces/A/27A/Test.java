//27A

import java.io.*;
import java.util.*;

public class Test
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for(int i = 0 ; i < n ; i++)
      arr.add(Integer.parseInt(s[i]));
    int nxt = 1;
    while(true)
    {
      if(!arr.contains(nxt))
        break ;
      nxt++;
    }
    System.out.println(nxt);
  }
}
