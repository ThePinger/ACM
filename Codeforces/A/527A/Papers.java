//527A
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Papers
{
  public static long ships(long a , long b)
  {
    long tmp = 1;
    long c = 0;
    while (tmp != 0)
    {
     c = c + (a/b);
     tmp = a % b;
     a = b;
     b = tmp;
    }
    return c;
  }

  public static void main(String[] args) throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr, 16 * 1024);
    String[] line0 = br.readLine().split(" ");
    long a = Long.parseLong(line0[0]);
    long b = Long.parseLong(line0[1]);
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(ships(a,b));
    pw.close();

  }
}
