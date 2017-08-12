
import java.io.*;
import java.util.*;

public class A
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int days = sc.nextInt();
    int candiesReq = sc.nextInt();
    int candiesAv = 0;
    int minD = 0;
    for(int i = 0 ; i < days ; i++)
    {
      int cn = sc.nextInt();
       candiesAv += cn;
       if(candiesReq > 0)
       {
         if(candiesAv > 8)
         {
           candiesReq -= 8;
           candiesAv -= 8;
         }
         else
         {
           candiesReq -= candiesAv;
           candiesAv = 0;
         }
         minD++;
       }
    }
    if(candiesReq > 0)
      System.out.println(-1);
    else
      System.out.println(minD);
  }
}
