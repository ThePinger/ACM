//686B

import java.util.*;
public class RobberGirl
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    int[] animals = new int[n];
    for(int i = 0 ; i < n ; i++)
      animals[i] = sc.nextInt();

    for(int i = 0 ; i < n ; i++)
      for(int j = 0 ; j < n - 1 ; j++)
         if(animals[j] > animals[j+1])
         {
           int tmp = animals[j];
           animals[j] = animals[j+1];
           animals[j+1] = tmp;
           sb.append((j + 1) + " " + (j + 2) + "\n");
         }
    //System.out.println(Arrays.toString(animals));
    System.out.print(sb);
  }
}
