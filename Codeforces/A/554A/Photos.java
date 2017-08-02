import java.util.*;

public class Photos
{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int books = 25;
    String s = sc.next();
    System.out.println(books * (s.length() + 1) + 1);
  }
}
