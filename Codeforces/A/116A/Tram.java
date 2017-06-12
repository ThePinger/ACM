//116A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.Point;

public class Tram
{
  public static int max(ArrayList<Point> e)
  {
    int max = 0 ;
    int in = 0 ;
    for(int i = 0 ; i < e.size(); i++)
    {
      in = in - e.get(i).x;
      in = in + e.get(i).y;
      if(in > max)
        max = in;
    }
    return max;
  }

  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024*16);
    int n = Integer.parseInt(br.readLine());
    ArrayList <Point> e = new ArrayList<Point>();
    for(int i = 0 ; i < n ; i++)
    {
      String[] s = br.readLine().split(" ");
      e.add(new Point(Integer.parseInt(s[0]) , Integer.parseInt(s[1])));
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(max(e));
    pw.close();
  }
}
