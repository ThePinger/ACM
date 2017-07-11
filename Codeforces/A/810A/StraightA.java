import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class StraightA
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int max = Integer.parseInt(s[1]);
    double sum = 0;
    String[] line = br.readLine().split(" ");
    ArrayList<Integer> grades = new ArrayList<Integer>();
    for(int i = 0 ; i < n ;i++)
    {
      int cur = Integer.parseInt(line[i]);
      sum += cur;
      grades.add(cur);
    }
    if(Math.round(sum/n) == max)
      System.out.println(0);
    else
    {
      boolean flag = true;
      int needed = 0;
      while(flag)
      {
        sum += max;
        if(Math.round(sum/(n+needed+1)) == max)
          flag = false;
        needed++;
      }
      System.out.println(needed);
    }
  }
}
