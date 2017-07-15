//58A
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Chat
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    ArrayList<Character> p = new ArrayList<Character>();
    if(s.length() < 5)
      System.out.println("NO");
    else
    {
      loop : for(int i = 0 ; i < s.length() ; i++)
      {
        char c = s.charAt(i);
        if(p.isEmpty() && c == 'h')
          p.add('h');
        else if(p.isEmpty() && c != 'h')
          continue loop;
        else
        {
          switch(p.get(p.size()-1))
          {
            case 'h': if(c == 'e')
                        p.add('e');
                      else
                        continue loop;
                      break;
            case 'e': if(c == 'l')
                        p.add('l');
                      else
                        continue loop;
                      break;
            case 'l':
                      if(c == 'l' && p.get(p.size()-2) != 'l')
                        p.add('l');
                      else if(c == 'o' && p.get(p.size()-2) == 'l')
                      {
                        p.add('o');
                        break loop;
                      }
                      else
                        continue loop;
                      break;
           }
          }
        }
        if(p.size() == 5)
          System.out.println("YES");
        else
          System.out.println("NO");
      }
    }
}
