//1260
//Sales
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < n ; i++)
    {
      int d = Integer.parseInt(br.readLine());
      int sum = 0;
      String[] s = br.readLine().split(" ");
      for(int c = 1 ; c < d ; c++)
      {
        int tmp = Integer.parseInt(s[c]);
        for(int j = 0 ; j < c ; j++)
        {
          int comp = Integer.parseInt(s[j]);
          if(tmp >= comp)
            sum++;
        }
      }
      System.out.println(sum);
    }
  }
}
