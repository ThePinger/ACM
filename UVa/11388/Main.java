//11388
//GCDLCM

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        while(t-->0)
        {
            int gcd = sc.nextInt();
            int lcm = sc.nextInt();
            pw.println(lcm % gcd == 0 ? gcd + " " + lcm : -1);
        }
        
        pw.flush();
        pw.close();
    }
}