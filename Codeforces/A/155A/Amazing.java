import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Amazing
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    int best = Integer.parseInt(s[0]);
    int worst = Integer.parseInt(s[0]);
    int amazing = 0;
    for(int i = 1 ; i < s.length ; i++)
    {
      int tmp = Integer.parseInt(s[i]);
      if(tmp > best)
      {
        amazing++;
        best = tmp;
      }
      else if(tmp < worst)
      {
        amazing++;
        worst = tmp;
      }
    }
    System.out.println(amazing);
  }
}
