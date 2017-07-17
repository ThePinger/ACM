//624
//CD
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
  static String[] s;
  static int max;
  static String ans;
  public static void countCD(int m , int i , String line)
  {
     if(i == s.length || m < 0)
     {
       if(m < max && m >= 0)
       {
         max = m;
         ans = line;
       }
       return ;
     }
     countCD(m - Integer.parseInt(s[i]) , i + 1, line+" "+s[i]);
     countCD(m , i+1 , line);
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String st ;
    while((st = br.readLine()) != null)
    {
      s = st.split(" ");
      int max_Size = Integer.parseInt(s[0]);
      max = max_Size;
      countCD(max_Size , 2 , "");
      System.out.println(ans.substring(1)+ " sum:" + (max_Size - max));
    }
  }
}
