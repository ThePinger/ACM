//343B
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class Wires
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    Stack <Character> wire = new Stack<Character>();
    for(int i = 0 ; i < s.length() ; i++)
    {
      if(wire.isEmpty())
        wire.push(s.charAt(i));
      else
      {
        if(wire.peek() == s.charAt(i))
          wire.pop();
        else
          wire.push(s.charAt(i));
      }
    }
    if(wire.isEmpty())
      System.out.println("Yes");
    else
      System.out.println("No");
  }
}
