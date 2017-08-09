import java.io.*;
import java.util.*;

public class MainF
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int sum = 0;
    int cars = 0;
    for(int i = 0 ; i < n ; i++)
      sum += sc.nextInt();
    while(sum > 0)
    {
        cars++;
        sum -= 5;
    }
    System.out.print(cars);
  }
}
