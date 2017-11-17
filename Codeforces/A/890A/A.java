
import java.io.*;
import java.util.*;

public class A
{

  public static void main(String[] args)throws IOException
  {
    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> arr = new ArrayList<>();
    int sum = 0;
    for(int i = 0 ; i < 6 ; i++)
    {
      int tmp = sc.nextInt();
      arr.add(tmp);
      sum += tmp;
    }
    
    if(sum % 2 != 0)
    {
      System.out.println("NO");
      return;
    }

    int poss = 0;
    for(int j = 1 ; j < 6 ; j++)
    {
      for(int c = j + 1 ; c < 6 ; c++)
      {
         poss = arr.get(0) + arr.get(j) + arr.get(c);
         if(poss == sum/2)
         {
           System.out.println("YES");
           return;
         }
      }
    }
    System.out.println("NO");
  }
}
