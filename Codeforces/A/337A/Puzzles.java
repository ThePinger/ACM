//337A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
public class Puzzles
{

  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr,16*1024);
    String[] s = br.readLine().split(" ");
    String[] pieces = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]) - 1;
    int m = Integer.parseInt(s[1]);
    ArrayList<Integer> p = new ArrayList<Integer>();
    for(int i = 0 ; i < m ; i++)
       p.add(Integer.parseInt(pieces[i]));
    Collections.sort(p);
    int min = p.get(n) - p.get(0) ;
    for(int j = 0 ; j < m ; j++)
    {
      if(m - n == j)
        break;
      int tmp = p.get(j + n) - p.get(j);
      if(tmp < min)
       min = tmp;
      tmp = 0;
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(min);
    pw.close();
  }
}
