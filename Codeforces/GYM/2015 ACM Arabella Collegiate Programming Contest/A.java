
import java.util.*;
import java.io.*;

public class A
{
    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();

        while(n-->0)
        {
            int x = sc.nextInt();
            String s = sc.next();
            int y = sc.nextInt();

            if(s.equals("!="))
            {
                if(x != y)
                    pw.println("true");
                else
                    pw.println("false");
            }
            else if(s.equals("=="))
            {
                if(x == y)
                    pw.println("true");
                else
                    pw.println("false");
            } 
            else if(s.equals("<"))
            {
                if(x < y)
                    pw.println("true");
                else
                    pw.println("false");
            } 
            else if(s.equals("<="))
            {
                if(x <= y)
                    pw.println("true");
                else
                    pw.println("false");
            }
            else if(s.equals(">"))
            {
                if(x > y)
                    pw.println("true");
                else
                    pw.println("false");
            }
            else if(s.equals(">="))
            {
                if(x >= y)
                    pw.println("true");
                else
                    pw.println("false");
            }
        }
        pw.flush();
        pw.close();
           
    }
}