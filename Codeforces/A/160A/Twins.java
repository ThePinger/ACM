//twins
import java.io.*;
import java.util.*;

public class Twins
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    ArrayList <Integer> a = new ArrayList<Integer>();
    int sum = 0;
    for(int i = 0 ; i < n ; i++)
    {
      int tmp = Integer.parseInt(s[i]);
      a.add(tmp);
      sum += tmp;
    }
    Collections.sort(a);
    int s1 = 0;
    int t1 = 0;
    int j = a.size()-1;
    while(s1 <= sum && j != -1)
    {
      s1 = s1 + a.get(j);
      sum = sum - a.get(j);
      t1++;
      j--;
    }
    System.out.println(t1);
   }
}
