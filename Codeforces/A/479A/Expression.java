//479A
import java.util.Scanner;

public class Expression
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int o = a + b + c;
    int o1 = a + b * c  ;
    int o2 = a *(b + c) ;
    int o3 = a * b * c  ;
    int o4 = (a + b) * c;
    int max = o;
    if(o1 > max)
      max = o1;
    if(o2 > max)
      max = o2;
    if(o3 > max)
      max = o3;
    if(o4 > max)
      max = o4;
    System.out.println(max);
  }
}
