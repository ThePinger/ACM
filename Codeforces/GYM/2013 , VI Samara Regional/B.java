import java.util.*;

public class B
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    double[] freq = new double[26];
    for(int i = 0 ; i < s.length() ; i++)
      freq[s.charAt(i)-97]++;
    double prob = 0;
    for(int i = 0 ; i < s.length() ;i++)
      prob += (freq[s.charAt(i)-97] / s.length());
    System.out.println(prob);
  }
}
