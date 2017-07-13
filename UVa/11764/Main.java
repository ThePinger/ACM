//11764
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int i = 0 ;  i < n ; i++)
    {
      int nt = Integer.parseInt(br.readLine());
      String[] s = br.readLine().split(" ");
      int longJ = 0 ;
      int shortJ = 0;
      for(int j = 0 ; j < nt-1 ; j++)
      {
         int cur = Integer.parseInt(s[j]);
         int nex = Integer.parseInt(s[j+1]);
         if(cur < nex)
           longJ++;
         else if(cur > nex)
           shortJ++;
      }
      System.out.println("Case " + (i+1) +": "+ longJ + " " +shortJ );
    }
  }
}
