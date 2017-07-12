//236A
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeSet;

public class SetSol
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TreeSet<Character> c = new TreeSet<Character>();
    String s = br.readLine();
    for(int i = 0 ; i < s.length() ; i++)
       c.add(s.charAt(i));
    if(c.size() % 2 == 0)
      System.out.println("CHAT WITH HER!");
    else
      System.out.println("IGNORE HIM!");
  }
}
