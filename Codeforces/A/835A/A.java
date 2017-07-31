//A

import java.io.*;
import java.util.*;

public class A
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    long ch = sc.nextLong();
    long v1 = sc.nextLong();
    long v2 = sc.nextLong();
    long t1 = sc.nextLong();
    long t2 = sc.nextLong();
    long first = t1 ;
    long second = t2 ;
    first = first + (ch*v1);
    second = second + (ch*v2);
    first += t1;
    second += t2;
    if(first == second)
      System.out.println("Friendship");
    else if(first < second)
      System.out.println("First");
    else
      System.out.println("Second");

  }
}
