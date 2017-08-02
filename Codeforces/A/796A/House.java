import java.io.*;
import java.util.*;

public class House
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int houses = Integer.parseInt(s[0]);
    int crush = Integer.parseInt(s[1]);
    int money = Integer.parseInt(s[2]);
    s = br.readLine().split(" ");
    int minD = (int) 1e9;
    loop : for(int i = 0 ; i < houses ; i++)
    {
      int cur = Integer.parseInt(s[i]);
      if(cur != 0)
      {
        int dist = Math.abs(crush - (i + 1));
        if(cur <= money && dist < minD)
          minD = dist;
      }
    }
    System.out.println(minD*10);
  }
}
