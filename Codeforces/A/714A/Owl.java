import java.util.*;

public class Owl
{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long l1 = sc.nextLong();
    long r1 = sc.nextLong();
    long l2 = sc.nextLong();
    long r2 = sc.nextLong();
    long k = sc.nextLong();
    long start = 0;
    if(l1 > l2)
      start = l1;
    else
      start = l2;
    long end = 0;
    if(r1 > r2)
      end = r2;
    else
      end = r1;
    if(start > end)
      System.out.println(0);
    else
    {
      long aval = end - start;
      if(k >= start && k <= end)
        aval--;
      System.out.println(aval+1);
    }
  }
}
