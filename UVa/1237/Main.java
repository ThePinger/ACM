//1237
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s ;
    int n = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < n ; i++)
    {
      if(i > 0)
        System.out.println("");
      int n1 = Integer.parseInt(br.readLine());
      ArrayList<String> name = new ArrayList<String>();
      ArrayList<Integer> pricesL = new ArrayList<Integer>();
      ArrayList<Integer> pricesH = new ArrayList<Integer>();
      for(int j = 0 ; j < n1 ; j++)
      {
        s = br.readLine().split(" ");
        name.add(s[0]);
        pricesL.add(Integer.parseInt(s[1]));
        pricesH.add(Integer.parseInt(s[2]));
      }
      int n2 = Integer.parseInt(br.readLine());
      int request;
      for(int c = 0 ; c < n2 ; c++)
      {
        ArrayList<String> ans = new ArrayList<String>();
        int qu = Integer.parseInt(br.readLine());
        for(int a = 0 ; a < name.size() && ans.size() < 2 ; a++)
        {
          if(pricesL.get(a) <= qu && pricesH.get(a) >= qu)
            ans.add(name.get(a));
        }
        if(ans.size() == 1)
          System.out.println(ans.get(0));
        else
         System.out.println("UNDETERMINED");
      }
    }
  }
}
