import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Police
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int officers = 0;
    int tmp;
    int crimes = 0;
    String[] s = br.readLine().split(" ");
    for(int i = 0 ; i < n ; i++)
    {
      tmp = Integer.parseInt(s[i]);
      if(tmp == -1 && officers == 0)
        crimes++;
      else if(tmp == -1 && officers > 0)
        officers--;
      else
        officers = officers + tmp;
    }
    System.out.println(crimes);
  }
}
