//Regestration System
import java.io.*;
import java.util.*;
public class Regestration
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    TreeMap <String , Integer> tm = new TreeMap<String,Integer>();
    for(int i = 0 ; i < n ;i++)
    {
      String tmp = br.readLine();
      if(tm.containsKey(tmp))
      {
        System.out.println(tmp +""+ tm.get(tmp));
        tm.put(tmp , tm.get(tmp) + 1);
      }
      else
      {
        System.out.println("OK");
        tm.put(tmp , 1);
      }
    }
  }
}
