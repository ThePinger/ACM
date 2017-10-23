
import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     while(true)
     {
       int n = Integer.parseInt(br.readLine());
       if(n == 0)
         return ;
       StringTokenizer st = new StringTokenizer(br.readLine());
       ArrayList<Integer> arr = new ArrayList<>();
       while(n-->0)
         arr.add(Integer.parseInt(st.nextToken()));
      int peaks = 0 ;
      for(int i = 0 ; i < arr.size() ; i++)
        if(i == 0)
        {
          if(arr.get(i) < arr.get(i+1) && arr.get(i) < arr.get(arr.size()-1) || arr.get(i) > arr.get(i+1) && arr.get(i) > arr.get(arr.size()-1))
            peaks++;
        }
        else if(i == arr.size() - 1)
        {
          if(arr.get(i) < arr.get(i-1) && arr.get(i) < arr.get(0) || arr.get(i) > arr.get(i-1) && arr.get(i) > arr.get(0))
            peaks++;
        }
        else if(arr.get(i) < arr.get(i-1) && arr.get(i) < arr.get(i+1) || arr.get(i) > arr.get(i-1) && arr.get(i) > arr.get(i+1))
          peaks++;
      System.out.println(peaks);
     }
  }
}
