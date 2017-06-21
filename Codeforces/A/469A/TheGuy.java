//469A
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class TheGuy
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16);
    int n = Integer.parseInt(br.readLine());
    String[] x = br.readLine().split(" ");
    String[] y = br.readLine().split(" ");
    ArrayList <Integer> a = new ArrayList<Integer>();
    for(int i = 1 ; i < Integer.parseInt(x[0]) + 1 ; i++)
    {
      if(!a.contains(Integer.parseInt(x[i])))
         a.add(Integer.parseInt(x[i]));
    }
    for(int i = 1 ; i < Integer.parseInt(y[0]) + 1 ; i++)
    {
      if(!a.contains(Integer.parseInt(y[i])))
         a.add(Integer.parseInt(y[i]));
    }
    if(a.size() == n)
      System.out.println("I become the guy.");
    else
      System.out.println("Oh, my keyboard!");
  }
}
