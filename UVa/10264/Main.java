//10264

import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    while(sc.hasNext())
    {
      int n = sc.nextInt();
      int[] arr = new int[(int)Math.pow(2,n)];
      for(int i = 0 ; i < arr.length ; i++)
        arr[i] = sc.nextInt();

      int[] potency = new int[arr.length];
      for(int i = 0 ; i < arr.length ; i++)
         for(int j = 0 ; j < n ; j++)
            potency[i] += arr[i ^ (1 << j)]; // XOR n times as each node connected to n nodes

      int max = 0;
      for(int i = 0 ; i < arr.length ; i++)
         for(int j = 0 ; j < n ; j++)
           max = Math.max(max , potency[i] + potency[i ^ (1 << j)]);

      sb.append(max + "\n");
    }
    System.out.print(sb);
  }
}
