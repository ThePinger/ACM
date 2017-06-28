//677A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Fence
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int height = Integer.parseInt(line[1]);
    String[] s = br.readLine().split(" ");
    int low = 0;
    int high = 0;
    for(int i = 0 ; i < n ; i++)
    {
       if(Integer.parseInt(s[i]) > height)
         high++;
       else
         low++;
    }
    System.out.println(low + (high * 2));
  }
}
