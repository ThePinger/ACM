


import java.io.*;
import java.util.*;

public class A
{
  public static void main(String[] args)throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    char[] s = br.readLine().toCharArray();
    int j = 0;
    int i = s.length - 1;
    while(i != j && i > -1 && j < s.length)
    {
      if(s[i] == '0' && j == 0)
      {
        i--;
        continue;
      }
      else if(s[i] != s[j])
      {
        System.out.println("NO");
        return;
      }
      i--;
      j++;
    }
    System.out.println("YES");

  }
}
