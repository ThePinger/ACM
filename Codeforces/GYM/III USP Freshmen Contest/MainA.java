import java.io.*;
import java.util.*;

public class MainA
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long ans = ((n*(n+1))/2)-(n-1);
    System.out.println(ans);
  }
}
