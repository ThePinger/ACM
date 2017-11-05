//11849
//CD

import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    while(true)
    {
      int n = sc.nextInt();
      int m = sc.nextInt();
      if(n == 0)
        break;

      HashSet <Integer> hs = new HashSet<>();
      while(n-->0)
        hs.add(sc.nextInt());

      int cd = 0;
      while(m-->0)
      {
        int tmp = sc.nextInt();
        if(hs.contains(tmp)) cd++;
      }
      sb.append(cd + "\n");
    }
    System.out.print(sb);
  }
}
