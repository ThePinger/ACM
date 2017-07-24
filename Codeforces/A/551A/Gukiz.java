import java.io.*;
import java.util.*;

public class Gukiz
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n  = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    for(int i = 0 ; i < n ; i++)
    {
      int higher = 1;
      int rating = Integer.parseInt(s[i]);
      for(int j = 0 ; j < n ; j++)
      {
        if(j != i && Integer.parseInt(s[j]) > rating)
          higher++;
      }
      System.out.print(higher + " ");
    }
  }
}
