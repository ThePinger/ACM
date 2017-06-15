//144A
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Point;

public class Row
{

  public static int seconds(ArrayList <Integer> row)
  {
    Point p = getMaxMin(row);
    if(p.x > p.y)
      return p.x + (row.size() - p.y) - 2;
    return p.x + row.size() - p.y - 1;
  }

  public static Point getMaxMin(ArrayList <Integer> row)
  {
    int max = row.get(0);
    int min = row.get(0);
    int x = 0;
    int y = 0;
    for(int i = 1 ; i < row.size() ; i++)
    {
      if(row.get(i) > max)
      {
        max = row.get(i);
        x = i;
      }
      if(row.get(i) <= min)
      {
        min = row.get(i);
        y = i;
      }
    }
    return new Point(x,y);
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList <Integer> row = new ArrayList<Integer>();
    for(int i = 0 ; i < n ; i++)
       row.add(sc.nextInt());
    System.out.println(seconds(row));
  }
}
