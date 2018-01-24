
import java.util.*;
import java.io.*;

public class B
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        
        while(n-->0)
        {
            int angle1 = sc.nextInt();
            int angle2 = sc.nextInt();
            int angle3 = sc.nextInt();
            
            if(angle1 + angle2 + angle3 == 180 && angle1 > 0 && angle2 > 0 && angle3 > 0)
                pw.println("YES");
            else
                pw.println("NO");
        }

        pw.flush();
        pw.close();
    }
}