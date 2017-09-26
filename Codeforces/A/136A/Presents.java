//136A
//Presents

import java.util.*;

public class Presents
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] order = new int[n+1];
    for(int i = 1 ; i < n + 1 ; i++)
      order[sc.nextInt()] = i;
    for(int i = 1 ; i < n + 1 ; i++)
      if(i == n)
       System.out.print(order[i]);
      else
       System.out.print(order[i] + " ");
  }
}
