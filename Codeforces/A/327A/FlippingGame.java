//327A

import java.util.*;

public class FlippingGame
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n ; i++)
       arr[i] = sc.nextInt();

    int maxOnes = 0;
    for(int i = 0 ; i < n ; i++)
    {
       int tmp = 0;
       int startOnes = 0;
       for(int j = 0; j < i ; j++)
          if(arr[j] == 1)
            startOnes++;

       for(int j = i ; j < n ; j++)
       {
         if(arr[j] == 0)
           tmp++;

         int endOnes = 0;
         for(int c = j + 1 ; c < n ; c++)
            if(arr[c] == 1)
              endOnes++;

         maxOnes = Math.max(maxOnes, tmp + endOnes + startOnes);
       }
    }

    System.out.println(maxOnes);
  }
}
