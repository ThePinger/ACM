//10664
//Luggage
//Brute-force
import java.io.*;

public class Main
{
  static String[] s;
  static boolean flag;
  public static void enough(int i , int car1 , int car2)
  {
    if(i == s.length)
    {
      if(car1 == car2)
        flag = true;
      return;
    }
    enough(i+1 , car1+Integer.parseInt(s[i]) , car2);
    enough(i+1 , car1 , car2+Integer.parseInt(s[i]));
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < n ;i++)
    {
      s = br.readLine().split(" ");
      flag = false;
      enough(0,0,0);
      if(flag)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
}
