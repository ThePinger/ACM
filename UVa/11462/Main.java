//11462
//AgeSort
//Counting Sort problem
import java.io.*;
import java.util.*;

public class Main
{

  static int[] freq;
  static int[] arr;
  static int[] newArr;
  public static void calculateFrequency()
  {
    for(int i = 0 ; i < arr.length ; i++)
      freq[arr[i]]++;
  }

  public static void updateFrequency()
  {
    for(int i = 1 ; i < 100 ; i++)
       freq[i] += freq[i-1];
  }

  public static void sortArray()
  {
    //Should add - smallest in case smallest element is not 0
    newArr = new int[arr.length];
    for(int i = newArr.length - 1; i > -1 ; i--)
    {
      if(freq[arr[i]] != 0)
      {
        newArr[freq[arr[i]] - 1] = arr[i];
        freq[arr[i]]--;
      }
    }
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true)
    {
      int n = Integer.parseInt(br.readLine());
      if(n == 0) break;
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr = new int[n];
      for(int i = 0 ; i < n ; i++)
        arr[i] = Integer.parseInt(st.nextToken());

      freq = new int[100];
      calculateFrequency();
      updateFrequency();
      sortArray();
      sb.append(newArr[0]);
      for(int i = 1 ; i < n ; i++)
        sb.append(" " + newArr[i]);

      sb.append("\n");
    }
    System.out.print(sb);
  }
}
