//519B

import java.io.*;
import java.util.*;

public class Errors
{
  public static void main(String[] args)throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    while(st.hasMoreTokens()) sum1 += Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    while(st.hasMoreTokens()) sum2 += Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    while(st.hasMoreTokens()) sum3 += Integer.parseInt(st.nextToken());

    System.out.println(sum1 - sum2);
    System.out.println(sum2 - sum3);
  }
}
