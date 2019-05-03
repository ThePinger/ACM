//1077A
//FrogJumping

import java.io.PrintWriter;
import java.util.*;

public class FrogJumping
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            int bjumps = k / 2;
            int ajumps = k - bjumps;
            pw.println(1l * a * ajumps - 1l * b * bjumps);
        }

        pw.flush();
        pw.close();
    }
}