
import java.io.*;
import java.util.*;

public class Main1
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum = 0;
    int odd = 0;
    ArrayList<Integer>arr = new ArrayList<Integer>();
    for(int i = 0 ; i < n ; i++)
    {
       int tmp = sc.nextInt();
       if(tmp % 2 == 0)
         sum += tmp;
       else
       {
         arr.add(tmp);
         odd += tmp;
       }
    }
    Collections.sort(arr);
    if(arr.size() % 2 == 0)
      System.out.println(sum + odd);
    else
    {
      while(arr.size() != 1)
      {
        sum += arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        sum += arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
      }
      System.out.println(sum);
    }
  }
}
