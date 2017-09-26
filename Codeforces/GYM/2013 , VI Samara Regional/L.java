
import java.util.Scanner;
import java.lang.StringBuilder;

public class L
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    char[] c = sc.next().toCharArray();
    int i = 0 ;
    int j = c.length - 1;
    while(i < j)
    {
      if(c[i] != c[j])
        c[j] = c[i];
      i++;
      j--;
    }
    StringBuilder sb = new StringBuilder();
    for(int cc = 0 ; cc < c.length ;cc++)
      sb.append(c[cc]);
    System.out.println(sb.toString());
    //System.out.println(solve(sc.nextLine()));
  }

  static String solve(String s)
  {
    char h = ' ';
    if (s.length() % 2 != 0)
      h = s.charAt((int) Math.ceil(s.length() / 2.0));
    StringBuilder d = new StringBuilder(s.substring(0, s.length() / 2));
    if(h != ' ')
      d.append(Character.toString(h));
    d.append(d.reverse().toString());
    return d.toString();
  }
}
