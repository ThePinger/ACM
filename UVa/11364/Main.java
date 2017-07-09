//11364
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr , 1024 * 16 );
    int n = Integer.parseInt(br.readLine());
    String[] s;
    int[] numbers;
    int size;
    int park;
    int distance;
    for(int i = 0 ; i < n ; i++)
    {
      size = Integer.parseInt(br.readLine());
      s = br.readLine().split(" ");
      numbers = new int[size];
      for(int j = 0 ; j < size ; j++)
         numbers[j] = Integer.parseInt(s[j]);
      Arrays.sort(numbers);
      park = numbers[0];
      distance = 0;
      for(int c = 0 ; c < size - 1 ; c++)
        distance = distance + numbers[c+1] - numbers[c];
      distance = distance + numbers[size-1] - park;
      System.out.println(distance);
    }
  }
}
