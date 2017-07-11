//158C
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import java.util.Arrays;

public class Commands
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack <String> cm = new Stack<String>();
    String[] s ;
    String[] command;
    Stack<String> tmp = new Stack<String>();
    for(int i = 0 ; i < n ; i++)
    {

      s = br.readLine().split(" ");
      if(s[0].equals("cd"))
      {
        command = s[1].split("/");
        if(command.length > 0 && command[0].equals(""))
        {
          while(!cm.isEmpty())
            cm.pop();
        }
        for(int c = 0 ; c < command.length ; c++)
        {
           if(command[c].equals(".."))
             cm.pop();
           else if(!command[c].equals(""))
             cm.push(command[c]);
        }
      }
      else
      {
        if(cm.isEmpty())
          System.out.println("/");
        else
        {
          String out = "/";
          while(!cm.isEmpty())
          {
            tmp.push(cm.peek());
            String a = cm.pop();
            out = "/" + a + out;
          }
          System.out.println(out);
          while(!tmp.isEmpty())
            cm.push(tmp.pop());
        }
      }
    }
  }
}
