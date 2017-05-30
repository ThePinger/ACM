//37A
import java.util.Scanner;
import java.util.ArrayList;

public class Towers
{
  public static void minTowers(ArrayList <Integer> height)
  {
    int max = 1 ;
    int maxH  = 0 ;
    int towers = height.size() ;
    for(int i = 0 ; i < height.size() ; i++)
    {
      int t = height.get(i);
      for(int j = 0 ; j < height.size() ; j++)
      {
        if(i != j)
        {
          if(t == height.get(j))
          {
            towers--;
            max++;
            height.remove(j);
            j--;
          }
        }
      }
      if(max > maxH)
        maxH = max;
      max = 1 ;
    }
    System.out.print(maxH + " " + towers);
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int towers = sc.nextInt();
    ArrayList <Integer> height = new ArrayList<Integer>();
    for(int i = 0 ; i < towers ; i++)
       height.add(sc.nextInt());
    minTowers(height);
  }
}
