import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
public class CrossWord
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split("W");
    int groups = s.length;
    ArrayList<Integer> size = new ArrayList<Integer>();
    for(int i = 0 ; i < s.length ; i++)
    {
      if(s[i].length() != 0)
       size.add(s[i].length());
      else
       groups--;
    }
    System.out.println(groups);
    for(int j = 0 ; j < size.size() ; j++)
      System.out.print(size.get(j) + " ");
  }
}
