//25A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class IQTest
{

  public static int pos(int n , int [] num)
  {
    ArrayList <Integer> even = even(num);
    ArrayList <Integer> odd = odd(num);
    if(even.size() > odd.size())
      return odd.get(0) + 1;
    else
      return even.get(0) + 1;

  }

  public static ArrayList<Integer> even(int [] num)
  {
    ArrayList <Integer> even = new ArrayList<Integer>();
    for(int i = 0 ; i < num.length ; i++)
    {
      if(num[i] % 2 == 0)
        even.add(i);
    }
    return even;
  }

  public static ArrayList<Integer> odd(int [] num)
  {
    ArrayList <Integer> odd = new ArrayList <Integer>();
    for(int i = 0 ; i < num.length ; i++)
    {
      if(num[i] % 2 != 0)
        odd.add(i);
    }
    return odd;
  }

  public static void main(String[] args) throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr, 16 * 1024);
    String[] line0 = br.readLine().split(" ");
    int n = Integer.parseInt(line0[0]);
    int [] num = new int[n];
    String[] line1 = br.readLine().split(" ");
    for(int i = 0 ; i < n ; i++)
       num[i] = Integer.parseInt(line1[i]);
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(pos(n ,num ));
    pw.close();
  }
}
