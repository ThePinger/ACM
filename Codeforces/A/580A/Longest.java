//580A
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Longest
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    int max = 1;
    int tmp = 1;
    for(int i = 0 ; i < n-1 ;i++)
    {
      long a = Long.parseLong(s[i]);
      long b = Long.parseLong(s[i+1]);
      if(a <= b)
        tmp++;
      else
      {
        if(tmp > max)
          max = tmp;
        tmp = 1 ;
      }
    }
    if(tmp > max)
      max = tmp;
    System.out.println(max);
  }
}
