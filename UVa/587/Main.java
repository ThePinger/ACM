//587
//There's treasure everywhere!

import java.text.DecimalFormat;
import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;

        while(true)
        {
            String line = sc.next();
            
            if(line.equals("END")) break;

            String[] splitted = line.split(",");
            double x = 0.0, y = 0.0;
            for(int i = 0; i < splitted.length; i++)
            {
                String cur = splitted[i];
                String tmp = "";
                String dir = "";
                for(int j = 0; j < cur.length(); j++)
                {
                    if(cur.charAt(j) < 'A' && cur.charAt(j) != '.')
                        tmp += cur.charAt(j);
                    else if(cur.charAt(j) != '.')
                        dir += cur.charAt(j);
                }

                int magnitude = Integer.parseInt(tmp);
                double xx = Math.sqrt((magnitude * magnitude) / 2.0);
                double yy = xx;

                switch(dir)
                {
                    case "N":  y += magnitude;   break;
                    case "S":  y -= magnitude;   break;
                    case "E":  x += magnitude;   break;
                    case "W":  x -= magnitude;   break;
                    case "NE": x += xx; y += yy; break;
                    case "NW": x -= xx; y += yy; break;
                    case "SW": x -= xx; y -= yy; break;
                    case "SE": x += xx; y -= yy; break;
                                   
                }
            }

            double ans = Math.sqrt((x * x) + (y * y));
            DecimalFormat df = new DecimalFormat("0.000");
            pw.println("Map #" + (t++));
            pw.println("The treasure is located at (" + df.format(Math.round(x * 1000) / 1000.0) + "," + df.format(Math.round(y * 1000) / 1000.0) + ").");
            pw.println("The distance to the treasure is " + df.format(Math.round(ans * 1000) / 1000.0) + ".");
            pw.println();
        }
        
        pw.flush();
        pw.close();
    }
}