import java.io.*;
import java.util.ArrayList;

public class VityaC
{
  public static void main(String[] args)throws IOException
  {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int n = Integer.parseInt(br.readLine());
     String[] s = br.readLine().split(" ");
     boolean state = false ;
     for(int i = 0 ; i < n -1 ; i++)
     {
        int today = Integer.parseInt(s[i]);
        int tmw = Integer.parseInt(s[i+1]);
        if(today > tmw)
          state = false;
        else
          state = true;
     }
     if(s[s.length -1].equals("0"))
       System.out.println("UP");
     else if(s[s.length-1].equals("15"))
       System.out.println("DOWN");
     else if(n == 1)
       System.out.println(-1);
     else
     {
      if(state)
        System.out.println("UP");
      else
        System.out.println("DOWN");
    }
  }
}
