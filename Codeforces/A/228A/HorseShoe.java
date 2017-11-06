//228A
import java.util.Scanner;
import java.util.TreeSet;

public class HorseShoe
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    TreeSet<Integer> ts = new TreeSet<>();
    for(int i = 0 ; i < 4 ; i++)
      ts.add(sc.nextInt());
    System.out.println(4 - ts.size());
  }
}
