//268A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Point;

public class Games
{
  public static int match(ArrayList<Point> kits)
  {
    int match = 0 ;
    for(int i = 0 ; i < kits.size() ; i++)
    {
      int h = kits.get(i).x;
      int a = kits.get(i).y;
      for(int j = i+1 ; j < kits.size() ; j++)
      {
        if(h == kits.get(j).y)
          match++;
        if(a == kits.get(j).x)
          match++;
      }
    }
    return match;
  }

  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    int n = Integer.parseInt(br.readLine());
    ArrayList <Point> kits = new ArrayList<Point>();
    for(int i = 0 ; i < n ; i++)
    {
      String[] s = br.readLine().split(" ");
      kits.add(new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
    }
    System.out.println(match(kits));
  }
}
