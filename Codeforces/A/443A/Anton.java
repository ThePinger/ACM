import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeSet;

public class Anton
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    TreeSet <Character> c = new TreeSet<Character>();
    if(s[0].charAt(1) != '}')
       c.add(s[0].charAt(1));
    for(int i = 1 ; i < s.length ; i++)
      c.add(s[i].charAt(0));
    System.out.println(c.size());
  }
}
