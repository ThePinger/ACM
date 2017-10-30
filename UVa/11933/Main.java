//11933
//Splitting Numbers

import java.util.*;
import java.io.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true)
    {
      int num = Integer.parseInt(br.readLine());
      if(num == 0)
        return ;
      char[] cc = Integer.toBinaryString(num).toCharArray();
      char[] a = new char[cc.length];
      char[] b = new char[cc.length];
      boolean f = true;
      int ao = 0;
      int bo = 0;
      for(int i = 0 ; i < cc.length ;i++)
         if(f)
         {
           if(cc[i] == '1')
           {
             a[i] = '1';
             f = false;
             ao++;
           }
           else
             a[i] = '0';
           b[i] = '0';
         }
         else
         {
           if(cc[i] == '1')
           {
             b[i] = '1';
             f = true;
             bo++;
           }
           else
             b[i] = '0';
           a[i] = '0';
         }
     if(ao > bo)
       System.out.println(Integer.parseInt(new String(a) , 2) + " " + Integer.parseInt(new String(b) , 2));
     else
       System.out.println(Integer.parseInt(new String(b) , 2) + " " + Integer.parseInt(new String(a) , 2));

    }
  }
}
