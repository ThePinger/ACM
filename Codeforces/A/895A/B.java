//A
//Pizza
import java.io.*;
import java.util.*;

public class B
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] pizza = new int[n];
    int min = Integer.MAX_VALUE;
    for(int i = 0 ; i < n  ; i++)
       pizza[i] = sc.nextInt();

    for(int i = 0 ; i < n ; i++)
    {
      int curSum = pizza[i];
      min = Math.min(Math.abs(curSum - (360 - curSum)), min);
      for(int j = i + 1 ; j < n ; j++)
      {
          curSum += pizza[j];
          min = Math.min(Math.abs(curSum - (360 - curSum)), min);
      }
    }
    System.out.println(min);
  }
}
