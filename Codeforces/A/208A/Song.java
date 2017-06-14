//208A
import java.util.Scanner;

public class Song
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.next().split("WUB");
    for(int i = 0 ; i < s.length ; i++)
       System.out.print(s[i] + " ");
  }
}
