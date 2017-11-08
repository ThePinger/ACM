
import java.io.*;
import java.util.*;

public class Main
{
  static final int INF = Integer.MAX_VALUE;
  static int swaps;
  static void mergeSort(int[] a, int b, int e)
  {
    if(b < e)
    {
      int q = (b + e) / 2;
      mergeSort(a, b, q);
      mergeSort(a, q + 1, e);
      merge(a, b, q, e);
    }
  }


  static void merge(int[] a, int b, int mid, int e)
  {
     int n1 = mid - b + 1;
     int n2 = e - mid;
     int[] L = new int[n1+1], R = new int[n2+1];

     for(int i = 0; i < n1; i++)  L[i] = a[b + i];
     for(int i = 0; i < n2; i++)  R[i] = a[mid + 1 + i];
     L[n1] = R[n2] = INF;

     for(int k = b, i = 0, j = 0; k <= e; k++)
       if(L[i] <= R[j])
       {
         a[k] = L[i++];
         swaps += j;
       }
       else
         a[k] = R[j++];
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    while(n-->0)
    {
      int trains = Integer.parseInt(br.readLine());
      int[] trainsArr = new int[trains];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0 ; i < trains; i++)
         trainsArr[i] = Integer.parseInt(st.nextToken());

      swaps = 0;
      mergeSort(trainsArr , 0 , trains - 1);
      sb.append("Optimal train swapping takes " + swaps + " swaps.\n");
    }
    System.out.print(sb);
  }
}
