import java.io.*;
import java.util.*;

public class Main
{
  static final int max = Integer.MAX_VALUE;
  static int flips;
  static void mergeSort(int[] arr ,int start ,int end)
  {
    if(start < end)
    {
      int mid = (start + end) / 2;
      mergeSort(arr , start , mid);
      mergeSort(arr , mid + 1 , end);
      merge(arr , start , mid , end);
    }
  }

  static void merge(int[] arr , int start , int mid , int end)
  {
    int end1 = mid - start + 1;
    int end2 = end - mid;
    int[] left = new int[end1 + 1];
    int[] right = new int[end2 + 1];
    for(int i = 0 ; i < end1 ; i++)
      left[i] = arr[i + start];
    for(int i = 0 ; i < end2 ; i++)
      right[i] = arr[i + mid + 1];

    left[end1] = max;
    right[end2] = max;
    for(int c = start , i = 0 , j = 0 ;c <= end; c++)
       if(left[i] <= right[j])
       {
         arr[c] = left[i++];
         flips += j;
       }
       else
         arr[c] = right[j++];
  }

  public static void main(String[] args)throws IOException
  {
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int[] arr;
    while(sc.hasNext())
    {
      int n = sc.nextInt();
      arr = new int[n];
      for(int i = 0 ; i < n ; i++)
          arr[i] = sc.nextInt();
      flips = 0;
      mergeSort(arr , 0 , n - 1);
      sb.append("Minimum exchange operations : " + flips + "\n");
    }
    System.out.print(sb);
  }
}
