
import java.util.Scanner;

public class Santa
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int[] freq = new int[26];
    String s = sc.next() + sc.next();
    for(int i = 0 ; i < s.length() ;i++)
       freq[s.charAt(i)-65]++;

    s = sc.next();
    for(int i = 0 ; i < s.length() ;i++)
       freq[s.charAt(i)-65]--;

    for(int i = 0 ; i < 26 ; i++)
       if(freq[i] != 0)
       {
         System.out.println("NO");
         return ;
       }

    System.out.println("YES");
  }
}
