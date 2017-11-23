
import java.util.*;

public class ZSort
{


  public static boolean isZSorted(int[] arr)
  {
    for(int i = 2; i < arr.length ;i++)
       if(i%2 == 0)
       {
         if(arr[i] < arr[i-1])
           return false;
       }
       else
       {
          if(arr[i] > arr[i-1])
            return false;
       }

    return true;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    int[] arr = new int[n + 1];
    for(int i = 1 ; i < n + 1; i++)
       arr[i] = sc.nextInt();

    for(int i = 1; i < n + 1; i++)
       for(int j = 2 ; j < n + 1; j++)
          if(j%2 == 0)
          {
            if(arr[j] >= arr[j-1])
              continue;
            else
            {
              int tmp = arr[j];
              arr[j] = arr[j-1];
              arr[j-1] = tmp;
            }
          }
          else
          {
            if(arr[j] <= arr[j-1])
              continue;
            else
            {
              int tmp = arr[j];
              arr[j] = arr[j-1];
              arr[j-1] = tmp;
            }
          }

    if(isZSorted(arr))
      for(int i = 1 ; i < n + 1 ; i++)
         sb.append(arr[i] + " ");
    else
      sb.append("Impossible");


    System.out.print(sb);
  }
}
