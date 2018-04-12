//253A
//BoysAndGirls

import java.io.*;
import java.util.*;

public class BoysAndGirls
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean turn = true;

        if(n < m) turn = false;

        while(n + m > 0)
        {
            if(turn && n > 0)
            {
                pw.print("B");
                n--;
            }
            else if(!turn && m > 0)
            {
                pw.print("G");
                m--;
            }
            else if(turn)
            {
                pw.print("G");
                m--;
            }
            else 
            {
                pw.print("B");
                n--;
            }

            turn = !turn;
        }

        pw.flush();
        pw.close();
    }
}