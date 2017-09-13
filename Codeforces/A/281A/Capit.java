//281A
//Word Capitalization

import java.io.*;

public class Capit
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] cc = br.readLine().toCharArray();
    System.out.print(Character.toUpperCase(cc[0]));
    for(int i = 1 ; i < cc.length ; i++)
      System.out.print(cc[i]);
  }
}
