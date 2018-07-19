//330B
//RoadConstruction

import java.io.*;
import java.util.*;

public class RoadConstruction
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] notRoot = new boolean[n + 1];
        while(m-->0)
            notRoot[sc.nextInt()] = notRoot[sc.nextInt()] = true;

        int start = -1;
        for(int i = 1; i < n + 1; i++)
            if(!notRoot[i])
            {
                start = i;
                break;
            }

        pw.println(n - 1);
        for(int i = 1; i < n + 1; i++)
            if(i != start)
                pw.println(start + " " + i);

        pw.flush();
        pw.close();
    }
}