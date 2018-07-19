//408
//Uniform Generator

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        while(sc.hasNext())
        {
            int step = sc.nextInt();
            int mod = sc.nextInt();
            boolean[] vis = new boolean[mod];
            int cur = 0;
            int count = 0;
            while(count < mod)
            {
                cur = (cur + step) % mod;
                if(vis[cur])
                {
                    count = -1;
                    break;
                }
                vis[cur] = true;
                count++;
            }

            String s = step + "";
            String m = mod + "";
            for(int i = 0; i < 10 - s.length(); i++)
                pw.print(" ");
            pw.print(s);

            for(int i = 0; i < 10 - m.length(); i++)
                pw.print(" ");
            pw.print(m);

            for(int i = 0; i < 4; i++)
                pw.print(" ");

            if(count == mod)
                pw.println("Good Choice");
            else
                pw.println("Bad Choice");

            pw.println();
        }

        pw.flush();
        pw.close();
    }
}