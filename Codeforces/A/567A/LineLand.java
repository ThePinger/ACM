import java.io.*;

public class LineLand
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] s = br.readLine().split(" ");
    for(int i = 0 ; i < n ; i++)
    {
      long cur = Long.parseLong(s[i]);
      long min = 0;
      long max = 0;
      long tmp = 0;
      long tmp2 = 0;
      if(i != 0)
         tmp = Math.abs(cur - Long.parseLong(s[0]));
      if(i != s.length-1)
         tmp2 = Math.abs(cur - Long.parseLong(s[s.length-1]));
      if(tmp == 0)
        max = tmp2;
      else if(tmp2 == 0)
        max = tmp;
      else
        max = Math.max(tmp,tmp2);
      if(i == 0)
        min = Math.abs(Long.parseLong(s[1]) - cur);
      else if(i == s.length -1)
        min = Math.abs(Long.parseLong(s[i - 1]) - cur);
      else
        min = Math.min(Math.abs(cur - Long.parseLong(s[i -1])), Math.abs(Long.parseLong(s[i + 1]) - cur));
      System.out.println(min + " " + max);
    }
  }
}
